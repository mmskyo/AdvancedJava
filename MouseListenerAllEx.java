import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseListenerAllEx extends JFrame{
	JLabel la = new JLabel(" ");
	
	public MouseListenerAllEx() {
		setTitle("MouseListenerAllEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
		
		c.add(la);
	
		
		setSize(300, 200);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	// implements 는 다중 상속이 가능하니까  extends 대신
	
	class MyMouseListener implements MouseListener, MouseMotionListener, java.awt.event.MouseListener {
		
		public void mousePressed(MouseEvent e) {
			la.setText("MousePressed ("+e.getX()+","+e.getY()+")");
		}
		
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseReleased ("+e.getX()+","+e.getY()+")");
		}
		
		public void mouseClicked(MouseEvent e) {
		}
		
		public void mouseEntered(MouseEvent e) {
			Component c = (Component)e.getSource();
			c.setBackground(Color.cyan);
		}
		
		public void mouseExited(MouseEvent e) {
			Component c = (Component)e.getSource();
			c.setBackground(Color.yellow);
		}
		
		public void mouseDragged(MouseEvent e) {
			la.setText("MouseDragged ("+e.getX()+","+e.getY()+")");
		}
		
		public void mouseMoved(MouseEvent e) {
			la.setText("MouseMoved (" +e.getX()+ "," + e.getY() + ")");
		}

		@Override
		public void mousePressed() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited() {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main (String [] args) {
		new MouseListenerAllEx();
	}
}
