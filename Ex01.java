import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class Ex01 extends JFrame implements ActionListener {
    private JTextField tf = new JTextField(30);
    private ArrayList<String> str = new ArrayList<>();
    private JComboBox<String> strList;  // ComboBox를 멤버 변수로 선언

    public Ex01() {
        setTitle("과제1");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // textfield
        tf.addActionListener(this);
        c.add(tf, BorderLayout.NORTH);

        // combo box
        strList = new JComboBox<>();
        c.add(strList, BorderLayout.NORTH);

        setVisible(true);
        tf.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JTextField) {
            String text = tf.getText();
            if (!text.isEmpty()) {
                str.add(text);  // ArrayList에 텍스트 추가
                strList.addItem(text);  // ComboBox에 아이템 추가
                tf.setText("");  // 텍스트 필드 비우기
            }
        }
    }

    public static void main(String[] args) {
        new Ex01();
    }
}
