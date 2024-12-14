import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseClass extends JFrame {
	
	//private JLabel textLa = new JLabel("Action");
	
	public MouseClass() {
		setTitle("Mouse Class");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		c.add(btn);
		btn.addMouseListener(new MyMouseListener());
		
		
		setSize(350, 150);
		setVisible(true);
		
	}
	
	public class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			JButton b = (JButton)e.getSource();
			
			if(b.getText().equals("Action"))
				b.setText("액션");
			else
				b.setText("Action");
			
			setTitle(b.getText());
			
		}
	
	}
	
	/*
	public class MyMouseListener implements MouseListener {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			textLa.setLocation(x, y);
			
		}
		public void mouseClicked(MouseEvent e) {};
		public void mouseReleased(MouseEvent e) {};
		public void mouseEntered(MouseEvent e) {};
		public void mouseExited(MouseEvent e) {};
	
	}
	*/
	
	public static void main(String [] args) {
		new MouseClass();
	}
}
