import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JButtonPrac extends JFrame {
	public JButtonPrac() {
		setTitle("버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		// c.setLayout(new FlowLayout());
		c.setLayout(null);
		
		ImageIcon normalIcon = new ImageIcon("../Images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("../Image/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("../Image/pressedIcon.jpg");
		
		JButton btn = new JButton("call", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
		btn.setSize(300, 200);
		btn.setLocation(150, 150);
		btn.setVerticalAlignment(SwingConstants.TOP);
		btn.setHorizontalAlignment(SwingConstants.RIGHT);
		
		c.add(btn);
		
		setSize(500, 500);
		setVisible(true);

	}
	
	public static void main(String [] args) {
		new JButtonPrac();
	}
}
