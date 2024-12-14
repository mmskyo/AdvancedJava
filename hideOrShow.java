import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;

	
class hideOrShow extends JFrame {
	private MyPanel panel = new MyPanel();


	public hideOrShow() {
		setTitle("Hide or Show");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300, 200);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("Images/sunset.JPG");
		private Image img = icon.getImage();
		private JButton btn = new JButton("Hide/Show");
		private boolean showFlag = true;
		
		public MyPanel() {
			setLayout(new FlowLayout());
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showFlag = !showFlag;
					repaint();
				}
			});
			add(btn);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(showFlag)
				g.drawImage(img,  0,  0,  this.getWidth(),  this.getHeight(),  this);
		}
	}
	
	public static void main(String [] args) {
		new hideOrShow();
	}
	
}
