import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultPanel extends JPanel {
    private JTextArea resultArea;
    private JButton restartButton;
    private GameFrame gameFrame;

    public ResultPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout());

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        restartButton = new JButton("처음으로");
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameFrame.showPanel("start");
            }
        });
        add(restartButton, BorderLayout.EAST);
        // 결과 보이기
        showResult();
    }

    public void showResult() {
        int satisfiedCustomers = gameFrame.getGame().getSatisfiedCustomers();
        StringBuilder sb = new StringBuilder();
        sb.append("게임결과\n");
        sb.append("만족시킨 고객의 수 : ").append(satisfiedCustomers).append("명\n");
        if (satisfiedCustomers >= 2) {
            sb.append("만족시킨 고객의 입소문을 타 멀리서도 찾아오는 가게가 되어 맛집이 되었다.\n");
            sb.append("축하합니다");
        } else {
            sb.append("아무도 만족하지않아 가게가 문을 닫았다.\n");
            sb.append("분발하세요");
        }
        resultArea.setText(sb.toString());
    }
}
