import java.util.*;

public class Order {
    private List<String> addToppings;
    private List<String> removeToppings;
    private String orderString;

    public Order(Game game) {
    	// 생성자 실행 
        generateOrder(game);
    }
    
    // 주문 랜덤 생성 
    private void generateOrder(Game game) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis()); // 타임 씨드로 랜덤 난수 설정
        addToppings = new ArrayList<>();
        removeToppings = new ArrayList<>();
        String[] availableToppings = game.getAvailableToppings();

        int addCount = random.nextInt(4) + 1; // 1~4개 추가
        int removeCount = random.nextInt(4); // 0~3개 제거

        // 추가할 토핑 랜덤 선택
        while (addToppings.size() < addCount) {
            String topping = availableToppings[random.nextInt(availableToppings.length)];
            if (!addToppings.contains(topping)) { // 중복 체크
                addToppings.add(topping);
            }
        }

        // 제거할 토핑 랜덤 선택
        while (removeToppings.size() < removeCount) {
            String topping;
            do {
                topping = availableToppings[random.nextInt(availableToppings.length)];
            } while (addToppings.contains(topping) || removeToppings.contains(topping)); // 중복 체크
            removeToppings.add(topping);
        }
        // 주문 문자열 생성 
        createOrderString();
    }
    
    private void createOrderString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(String.join(", ", addToppings)).append("} 넣어주세요. \n");
        if (!removeToppings.isEmpty()) {
            sb.append("{").append(String.join(", ", removeToppings)).append("} 빼주세요.");
        }
        orderString = sb.toString();
    }

    // 조건을 충족했는가?
    public boolean isSatisfied(Pizza pizza) {
        List<String> pizzaToppings = pizza.getToppings();

        // 기본 토핑 체크
        if (!pizzaToppings.contains("토마토 소스") || !pizzaToppings.contains("치즈")) {
            return false;
        }

        // 추가해야 할 토핑 확인
        for (String topping : addToppings) {
            if (!pizzaToppings.contains(topping)) {
                return false;
            }
        }

        // 제거해야 할 토핑 확인
        for (String topping : removeToppings) {
            if (pizzaToppings.contains(topping)) {
                return false;
            }
        }

        return true; // 모든 조건을 충족하면 true 반환
    }

    public String getOrderString() {
        return orderString;
    }
}
