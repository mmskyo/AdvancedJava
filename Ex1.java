import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex1 extends JFrame implements ActionListener{
	private JTextField tf = new JTextField(30);
	private String [] str = {};
	private int i = 0;
	
	public Ex1() {
		setTitle("과제1");
		setSize(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// textfield
		tf.addActionListener(this);
		c.add(tf, BorderLayout.NORTH);
		
		// combo box
		JComboBox strList = new JComboBox();
		strList.setSelectedIndex(i);
		strList.addActionListener(this);
		c.add(strList, BorderLayout.NORTH);
		
		setVisible(true);
		tf.requestFocus();
	}
	
	// 선택상태인 아이템의 인덱스 번호를 0부터 객체를 얻어 리턴
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			String text = tf.getText();
			str[i] = text;
			i++;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		// int index = cb.getSelectedIndex();
		// String text = (String) cb.getSelectedItem();
		String text = str[i];
		cb.addItem(text);
	}

	public static void main(String [] args) {
		new Ex1();
	}
}
