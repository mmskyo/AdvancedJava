import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel currentPanel;
    private StartPanel startPanel;
    private OrderPanel orderPanel;
    private PizzaMakingPanel pizzaMakingPanel;
    private ReviewPanel reviewPanel;
    private ResultPanel resultPanel;
    private Game game = new Game(this);

    public GameFrame() {
        setTitle("피자 킹");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        game = new Game();

        startPanel = new StartPanel(this);
        orderPanel = new OrderPanel(this);
        pizzaMakingPanel = new PizzaMakingPanel(this);
        reviewPanel = new ReviewPanel(this);
        resultPanel = new ResultPanel(this);

        mainPanel.add(startPanel, "start");
        mainPanel.add(orderPanel, "order");
        mainPanel.add(pizzaMakingPanel, "pizzaMaking");
        mainPanel.add(reviewPanel, "review");
        mainPanel.add(resultPanel, "result");

        add(mainPanel);
    }

    public void showPanel(String panelName) {
        if (currentPanel != null) {
            currentPanel.setVisible(false);
            currentPanel.setEnabled(false);
        }

        cardLayout.show(mainPanel, panelName);
        currentPanel = (JPanel) mainPanel.getComponent(mainPanel.getComponentCount() - 1);
        currentPanel.setVisible(true);
        currentPanel.setEnabled(true);
    }
    
    public Game getGame() {
        return game;
    }
    
    public ReviewPanel getReviewPanel() {
        return reviewPanel;
    }
    
    public OrderPanel getOrderPanel() {
        return orderPanel;
    }
    public void updateOrderPanel() {
        orderPanel.updateOrder();
    }
}
