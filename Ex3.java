import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex3 extends JFrame implements ActionListener{
	private JRadioButton color, size;
	private JPanel radioPanel;
	
	public Ex3() {
		setTitle("라디오 버튼 테스트");
		setSize(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		radioPanel = new JPanel();
		color = new JRadioButton("색상");
		size = new JRadioButton("크기");
		
		ButtonGroup radio = new ButtonGroup();
		size.add(color);
		size.add(size);
		
		color.addActionListener(this);
		size.addActionListener(this);
		
		radioPanel.add(color);
		radioPanel.add(size);
		c.add(radioPanel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	public static void main(String [] args) {
		new Ex3();
	}
}
