import javax.swing.*;
import java.awt.*;

public class TestEx extends JFrame{
	public TestEx() {
		setTitle("TestEx01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 4, 5, 5));
		
		for(int i = 1; i < 11; i++) 
			c.add(new JButton(Integer.toString(i))).setBackground(Color.green);
		
		JButton b = new JButton("1");
		c.add(b);
		b.setBackground(Color.black);;
		b.setForeground(Color.white);
		//c.add(new JButton("1")).setBackground(Color.black);
		c.add(new JButton("2")).setBackground(Color.gray);
		c.add(new JButton("3")).setBackground(Color.pink);
	
			setSize(300, 200);
			setVisible(true);
	}
	public static void main(String[] args) {
		new TestEx();
	}
}
