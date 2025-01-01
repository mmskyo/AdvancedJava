import java.util.*;

public class Game {
	private List<String> currentToppings; // 현재 토핑 리스트
	private String[] availableToppings = {"페퍼로니", "버섯", "양파", "파인애플", "고기", "감자", "브로콜리"};
    private List<Order> orders;
    private int orderNo = 4;
    private int currentOrderIndex = 0;
    private int satisfiedCustomers = 0;
	private GameFrame gameFrame;

    public Game() {
        orders = new ArrayList<>();
        currentToppings = new ArrayList<>(); // 초기화
        satisfiedCustomers = 0; 
        generateOrders(); 
    }
    
    public Game(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        orders = new ArrayList<>();
        generateOrders();
    }

    // 주문이 들어갈 배열 생성
    private void generateOrders() {
        for (int i = 0; i < orderNo; i++) {
            orders.add(new Order(this)); // 각 주문 생성
        }
    }
    // 현재 주문 반환 - indexOutOfBounds 
    public Order getCurrentOrder() {
    	return orders.get(currentOrderIndex);
    }
    // 다음 주문 
    public void nextOrder() {
        if (currentOrderIndex < orders.size() - 1) {
            currentOrderIndex++;
            // 새로운 주문 생성
            orders.set(currentOrderIndex, new Order(this));
        } else {
            // 모든 주문이 완료된 경우 처리
            currentOrderIndex = orders.size(); // 인덱스 유지
        }
    }
    // 게임 종료 
    public boolean isGameOver() {
        return currentOrderIndex >= orders.size(); // 모든 주문이 완료된 경우
    }
    // 리뷰 평가 
    public boolean evaluateOrder(Pizza pizza) {
        Order currentOrder = getCurrentOrder();
        boolean isSatisfied = currentOrder.isSatisfied(pizza);
        
        if (isSatisfied) {
            satisfiedCustomers++; // 고객 수 증가
        }
        
        return isSatisfied; // 만족 여부 반환
    }
    public int getSatisfiedCustomers() {
        return satisfiedCustomers;
    }

    public String[] getAvailableToppings() {
        return availableToppings;
    }
    public List<String> getCurrentToppings() {
        return currentToppings; // 현재 토핑 반환
    }

    public void setCurrentToppings(List<String> toppings) {
        this.currentToppings = toppings; // 현재 토핑 설정
    }
}