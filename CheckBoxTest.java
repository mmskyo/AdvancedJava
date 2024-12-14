import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxTest extends JFrame {
	private JLabel la = new JLabel();
	
	public CheckBoxTest() {
		
		setTitle("CheckBox Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1));
		
		Container c = getContentPane();
		
		JCheckBox checkbox1 = new JCheckBox("피자");
		JCheckBox checkbox2 = new JCheckBox("스파게티");
		
		c.add(checkbox1);
		c.add(checkbox2);
		c.add(la);
		
		checkbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				la.setText("피자가 " + (e.getStateChange() == 1 ? "선택되었습니다." : "선택해제되었습니다."));
			}
		});
		checkbox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				la.setText("스파게티가 " + (e.getStateChange() == 1 ? "선택되었습니다." : "산택해제되었습니다"));
			}
		});
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new CheckBoxTest();
	}
}
