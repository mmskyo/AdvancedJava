import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;

// 세개의 레이블이 0~4 사이의 랜덤 수를 발생한다. 엔터를 입력할 시 세개의 랜덤 수가 생성된다. 모두 같을 시 "축하합니다" 출력, 다르면 "아쉽군요" 출력
// 시도 횟수도 추가
public class GamblingGame extends JFrame {
    private JLabel num[];  // 숫자를 표시할 레이블 배열
    private JLabel resultLabel; // 결과를 출력할 레이블
    private JLabel attemptsLabel; // 시도 횟수를 표시할 레이블
    private int attempts = 0;  // 시도 횟수
    Random rand = new Random();

    public GamblingGame() {
        setTitle("Gambling Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // KeyListener를 컨테이너에 추가
        c.addKeyListener(new MyKeyListener());

        // 세 개의 숫자 레이블 생성
        num = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            num[i] = new JLabel("0"); 
            num[i].setOpaque(true);  // 배경색 설정 가능하게 설정
            num[i].setBackground(Color.magenta);
            num[i].setForeground(Color.yellow);
            num[i].setFont(new Font("Arial", Font.PLAIN, 50));  // 큰 폰트로 설정
            c.add(num[i]);
        }

        // 결과 레이블 생성
        resultLabel = new JLabel(" ");
        c.add(resultLabel);

        // 시도 횟수 레이블 생성
        attemptsLabel = new JLabel("시도 횟수: 0");
        c.add(attemptsLabel);

        setSize(300, 200);
        setVisible(true);

        // 초기 포커스를 설정
        c.setFocusable(true);
        c.requestFocus();
    }

    // KeyListener 클래스
    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                // 엔터 키 입력 시 랜덤 숫자를 3개 생성
                int[] values = new int[3];
                for (int i = 0; i < 3; i++) {
                    values[i] = rand.nextInt(5);  // 0 ~ 4 사이의 숫자 생성
                    num[i].setText(Integer.toString(values[i]));
                }

                // 시도 횟수 증가
                attempts++;
                attemptsLabel.setText("시도 횟수: " + attempts);

                // 세 숫자가 모두 같은지 확인
                if (values[0] == values[1] && values[1] == values[2]) {
                    resultLabel.setText("축하합니다!");
                } else {
                    resultLabel.setText("아쉽군요");
                }
            }
        }
    }

    public static void main(String[] args) {
        new GamblingGame();
    }
}
