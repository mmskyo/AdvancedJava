import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrderPanel extends JPanel {
    private JTextArea orderTextArea;
    private JButton acceptButton;
    private GameFrame gameFrame;

    public OrderPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout());
        orderTextArea = new JTextArea();
        orderTextArea.setEditable(false);
        orderTextArea.setFont(new Font("Serif", Font.PLAIN, 30));
        add(new JScrollPane(orderTextArea), BorderLayout.CENTER);

        // 피자 만들기 버튼 
        acceptButton = new JButton("만들기");
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameFrame.showPanel("pizzaMaking");
            }
        });
        add(acceptButton, BorderLayout.SOUTH);

        updateOrder();
    }

    public void updateOrder() {
        Order currentOrder = gameFrame.getGame().getCurrentOrder();
        if (currentOrder != null) { // try catch로 바꿔
            orderTextArea.setText(currentOrder.getOrderString());
            System.out.println("Updated Order Panel with: " + currentOrder.getOrderString()); // 디버깅 출력
        } else {
            orderTextArea.setText("주문이 없습니다.");
            System.out.println("No order to display."); // 디버깅 출력
        }
    }

}
