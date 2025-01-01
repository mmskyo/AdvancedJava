import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ReviewPanel extends JPanel {
    private JTextArea reviewArea;
    private JButton nextButton;
    private GameFrame gameFrame;

    public ReviewPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout());

        reviewArea = new JTextArea();
        reviewArea.setEditable(false);
        add(new JScrollPane(reviewArea), BorderLayout.CENTER);

        nextButton = new JButton("다음");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (gameFrame.getGame().isGameOver()) {
                    // 모든 주문이 완료된 경우 결과 화면으로 이동
                    gameFrame.showPanel("result");
                } else {
                    // 다음 주문으로 넘어가기 전에 현재 주문을 업데이트하고 주문 화면으로 이동
                    gameFrame.getGame().nextOrder();
                    gameFrame.updateOrderPanel();
                    gameFrame.showPanel("order");
                }
            }
        });
        add(nextButton, BorderLayout.SOUTH);
    }

    public void updateReview(Order order, boolean isSatisfied) {
        StringBuilder sb = new StringBuilder();
        sb.append(order.getOrderString()).append("\n");
        sb.append("**************\n");

        // Game에서 currentToppings 가져오기
        List<String> currentToppings = gameFrame.getGame().getCurrentToppings(); 
        sb.append("현재 토핑: ").append(String.join(", ", currentToppings)).append("\n");

        sb.append("리뷰 : ").append(isSatisfied ? "만족스럽네요^^. 또 시킬게요." : "불만족스럽네요.").append("\n\n");

        reviewArea.append(sb.toString());
    }
}