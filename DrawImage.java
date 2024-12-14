import java.awt.*;
import java.awt.Image;
import javax.swing.*;



public class DrawImage extends JFrame{

	private MyPanel panel = new MyPanel();

	

	public DrawImage() {

		setTitle("패널의 크기에 맞추어 이미지 그리기");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);

		setSize(200, 300);

		setVisible(true);

	}

	

	class MyPanel extends JPanel {

		private ImageIcon icon = new ImageIcon("Images/test.jpg");

		private Image img = icon.getImage();

		

		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			// 1

			//g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

			//2

			g.drawImage(img,  20,  20,  250,  100,  100,  50,  200,  200,  null);

			g.drawImage(img,  20,  220,  120,  270,  100,  50,  200,  200,  this);

		}

	}

	

	public static void main(String [] args) {

		new DrawImage();

	}

}