import java.awt.*;
import java.awt.Image;
import javax.swing.*;



public class GraphicClip extends JFrame {

	private MyPanel panel = new MyPanel();

	private ImageIcon icon = new ImageIcon("Images/test.jpg");

	private Image img = icon.getImage();

	

	public GraphicClip() {

		setTitle("패널의 크기에 맞추어 이미지 그리기");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);

		// 이미지 사이즈대로 창 생성

		setSize(icon.getIconWidth(), icon.getIconHeight());

		setVisible(true);

	}

	

	class MyPanel extends JPanel {

		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			

			// 꼭 클리핑 먼저

			// 최고넓이에서 가장 끝 x축에서 150만큼 클리핑하고싶으니까 가능한지(일반화)

			if(icon.getIconWidth()-100 < 150)

				g.setClip(100, 20, icon.getIconWidth() - 100, 150);

			else

				g.setClip(100, 20, 150, 150);

			

			g.drawImage(img,  0,  0, Color.RED, this);





			g.setColor(Color.YELLOW);

			g.setFont(new Font("Arial", Font.ITALIC, 40));

			g.drawString("Go Gator!!", 10, 150);

		}

	}

	

	public static void main(String [] args) {

		new GraphicClip();

	} 

}