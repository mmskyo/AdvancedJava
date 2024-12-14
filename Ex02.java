import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex02 extends JFrame implements ActionListener {
    private JTextField tf = new JTextField(10);  // 금액 입력 텍스트 필드
    private JTextArea ta50k, ta10k, ta5k, ta1k, taCoin;  // 결과를 출력할 텍스트 에리어들
    private JButton btn;

    public Ex02() {
        setTitle("과제 2");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 레이아웃 설정 (상단은 금액 입력 필드, 하단은 변환 결과 출력)
        setLayout(new BorderLayout());

        // 상단 패널 (금액 입력 필드와 계산 버튼을 한 줄로 배치)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel la = new JLabel("금액:");
        inputPanel.add(la);
        inputPanel.add(tf);

        btn = new JButton("계산");
        btn.addActionListener(this);
        inputPanel.add(btn);

        // inputPanel을 프레임의 상단에 추가
        add(inputPanel, BorderLayout.NORTH);

        // 하단 패널 (라벨과 텍스트 에리어를 한 줄씩 배치)
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(5, 2, 10, 10));  // 5행 2열, 간격 10px

        // 오만원권
        JLabel la1 = new JLabel("오만원권:");
        resultPanel.add(la1);
        ta50k = new JTextArea(1, 10);
        ta50k.setEditable(false);
        resultPanel.add(ta50k);

        // 만원권
        JLabel la2 = new JLabel("만원권:");
        resultPanel.add(la2);
        ta10k = new JTextArea(1, 10);
        ta10k.setEditable(false);
        resultPanel.add(ta10k);

        // 오천원권
        JLabel la3 = new JLabel("오천원권:");
        resultPanel.add(la3);
        ta5k = new JTextArea(1, 10);
        ta5k.setEditable(false);
        resultPanel.add(ta5k);

        // 천원권
        JLabel la4 = new JLabel("천원권:");
        resultPanel.add(la4);
        ta1k = new JTextArea(1, 10);
        ta1k.setEditable(false);
        resultPanel.add(ta1k);

        // 동전
        JLabel la5 = new JLabel("동전:");
        resultPanel.add(la5);
        taCoin = new JTextArea(1, 10);
        taCoin.setEditable(false);
        resultPanel.add(taCoin);

        // resultPanel을 프레임의 센터에 추가
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // 입력된 금액을 가져옴
            int amount = Integer.parseInt(tf.getText());

            // 금액을 화폐 단위로 나누기
            int count50k = amount / 50000;
            amount %= 50000;
            int count10k = amount / 10000;
            amount %= 10000;
            int count5k = amount / 5000;
            amount %= 5000;
            int count1k = amount / 1000;
            amount %= 1000;

            // 남은 금액은 동전으로 처리
            int coins = amount;

            // 결과를 텍스트 영역에 표시
            ta50k.setText(String.valueOf(count50k) + "장");
            ta10k.setText(String.valueOf(count10k) + "장");
            ta5k.setText(String.valueOf(count5k) + "장");
            ta1k.setText(String.valueOf(count1k) + "장");
            taCoin.setText(String.valueOf(coins) + "원");
        } catch (NumberFormatException ex) {
            // 금액 입력이 잘못되었을 때 처리
            JOptionPane.showMessageDialog(this, "올바른 금액을 입력하세요.");
        }
    }

    public static void main(String[] args) {
        new Ex02();
    }
}

