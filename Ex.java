import java.awt.*;

import javax.swing.*;



public class Ex extends JFrame{

	private MyPanel panel = new MyPanel();


	public Ex() {

		setTitle("3color");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);

		setSize(300, 200);

		setVisible(true);

	}


	class MyPanel extends JPanel {

		public void paintComponent(Graphics g) {

			super.paintComponent(g);


			g.setColor(Color.RED);

			g.fillRect(10, 10, 50, 50);


			g.setColor(Color.BLUE);

			g.drawOval(10,  70,  50,  50);


			g.setColor(Color.GREEN);

			g.drawRoundRect(10,  130,  50,  50,  20,  20);


			g.setColor(Color.MAGENTA);

			g.fillArc(10,  190,  50,  50,  20,  20);


			g.setColor(Color.ORANGE);

			int [] x = {30, 10, 30, 60};

			int [] y = {250, 275, 300, 275};

			g.fillPolygon(x, y, 4);


			g.setColor(Color.RED);

			g.fillArc(10, 310, 70, 70, 90, 120);


			g.setColor(Color.BLUE);

			g.fillArc(10, 310, 70, 70, 210, 120);


			g.setColor(Color.YELLOW);

			g.fillArc(10, 310, 70, 70, 330, 120);

		}

	}


	public static void main(String [] args) {

		new Ex();

	}

}