import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class PizzaMakingPanel extends JPanel {
    private JLabel statusLabel;
    private JButton doneButton;
    private JPanel toppingPanel;
    private JPanel pizzaPanel;
    private JPanel statusPanel;
    private String[] toppings = {"토마토 소스", "치즈", "페페로니", "양파", "브로콜리", "버섯", "파인애플", "고기", "감자"};
    private JButton[] toppingButtons = new JButton[9];
    private ArrayList<String> currentToppings = new ArrayList<>();
    private Random random = new Random(); // 토핑 위치 랜덤 

    public PizzaMakingPanel(GameFrame gameFrame) {
        setLayout(new BorderLayout());

        // 토핑 패널
        toppingPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        // 이미지 아이콘 생성 크기 조정
        for (int i = 0; i < toppings.length; i++) {
            ImageIcon originalIcon = new ImageIcon("images/" + toppings[i] + ".jpg");
            Image image = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);
            toppingButtons[i] = new JButton(toppings[i], scaledIcon);
            toppingButtons[i].setVerticalTextPosition(JButton.BOTTOM);
            toppingButtons[i].setHorizontalTextPosition(JButton.CENTER);
            toppingButtons[i].setPreferredSize(new Dimension(60, 60));
            toppingPanel.add(toppingButtons[i]);
        }
        
        // 피자 패널
        pizzaPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawPizza(g);
            }
        };
        
        // 피자 패널 사이
        pizzaPanel.setPreferredSize(new Dimension(300, 300));
        pizzaPanel.setBackground(Color.WHITE); // 배경색 추가로 패널 영역 확인


        // 상태 및 완성 버튼 패널
        statusPanel = new JPanel(new BorderLayout());
        statusLabel = new JLabel("현재 상태 : ");
        doneButton = new JButton("완성");
        statusPanel.add(statusLabel, BorderLayout.CENTER);
        statusPanel.add(doneButton, BorderLayout.EAST);

        // 전체 레이아웃 구성
        add(toppingPanel, BorderLayout.WEST);
        add(pizzaPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        // 토핑 버튼 이벤트 처리
        for (JButton button : toppingButtons) {
        	button.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String topping = ((JButton)e.getSource()).getText();
        	        updateStatus(topping);
        	        pizzaPanel.repaint();
        	    }
        	});

        }
        // 완성 버튼
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pizza madePizza = new Pizza(new ArrayList<>(currentToppings));
                gameFrame.getGame().setCurrentToppings(currentToppings); // 현재 토핑 설정
                
                boolean isSatisfied = gameFrame.getGame().evaluateOrder(madePizza); // 주문 만족 여부 평가
                
                // 리뷰 업데이트
                gameFrame.getReviewPanel().updateReview(gameFrame.getGame().getCurrentOrder(), isSatisfied);
                
                // 다음 회차 준비 - 패널 초기화
                currentToppings.clear();
                statusLabel.setText("현재 상태 : "); 
                pizzaPanel.repaint();
                
                // 리뷰패널로 넘어가
                gameFrame.showPanel("review");
            }
        });
    }
    private void updateStatus(String topping) {
    	// 버튼을 다시 누르면 토핑을 제거 
        if (currentToppings.contains(topping)) {
            currentToppings.remove(topping);
        } else {
            currentToppings.add(topping);
        }
        statusLabel.setText("현재 상태 : " + String.join(", ", currentToppings));
    }

    // 피자 베이스
    private void drawPizza(Graphics g) {
        // 도우 그리기
        g.setColor(new Color(225, 177, 81));
        g.fillOval(50, 50, 200, 200);

        // 토핑 그리기
        for (String topping : currentToppings) {
            drawToppings(g, topping);
        }
    }

    // 토핑  그리기
    private void drawToppings(Graphics g, String topping) {
        int centerX = 150;
        int centerY = 150;
        int radius = 90;

        for (int i = 0; i < 9; i++) {
            double angle = random.nextDouble() * 2 * Math.PI;
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));

            switch (topping) {
            	case "토마토 소스":
            		g.setColor(Color.red);
            		g.fillOval(55, 55, 190, 190);
            		break;
            	case "치즈":
            		g.setColor(new Color(255, 220, 101));
            		g.fillOval(55, 55, 190, 190);
            		break;
                case "페페로니":
                    g.setColor(new Color(225, 124, 81));
                    g.fillOval(x - 10, y - 10, 20, 20);
                    break;
                case "양파":
                    g.setColor(Color.white);
                    g.drawOval(x - 7, y - 7, 15, 15);
                    break;
                case "브로콜리":
                    g.setColor(Color.green);
                    int[] xPoints = {x, x-5, x, x+5};
                    int[] yPoints = {y-5, y+5, y+10, y+5};
                    g.fillPolygon(xPoints, yPoints, 4);
                    break;
                case "버섯":
                    g.setColor(Color.gray);
                    g.fillOval(x - 10, y - 5, 20, 10);
                    break;
                case "파인애플":
                    g.setColor(Color.yellow);
                    g.fillArc(x - 10, y - 10, 20, 20, 330, 30);
                    break;
                case "고기":
                    g.setColor(new Color(158, 122, 4));
                    g.fillOval(x - 5, y - 10, 10, 20);
                    break;
                case "감자":
                    g.setColor(new Color(225, 204, 137));
                    g.fillArc(x - 10, y - 10, 20, 20, 180, 180);
                    break;
            }
        }

    }
}