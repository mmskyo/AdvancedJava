import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List.*;

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
                    gameFrame.showPanel("result");
                } else {
                	// 주문 상태 초기화하고 주문 화면으로 이동 
                    gameFrame.getGame().nextOrder();
                    gameFrame.updateOrderPanel();
                    gameFrame.showPanel("order");
                }
            }
        });
        add(nextButton, BorderLayout.SOUTH);
    }
    // 리뷰 append 
    public void updateReview(Order order, boolean isSatisfied) {
        StringBuilder sb = new StringBuilder();
        sb.append(order.getOrderString()).append("\n");
        sb.append("**************\n");
        
        sb.append("리뷰 : ").append(isSatisfied ? "만족스럽네요^^. 또 시킬게요." : "불만족스럽네요.").append("\n\n");
        
        reviewArea.append(sb.toString());
    }
}
