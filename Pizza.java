import java.util.List;
import java.util.ArrayList;

public class Pizza {
    private List<String> toppings;

    public Pizza(List<String> toppings) {
        this.toppings = new ArrayList<>(toppings);
    }

    public List<String> getToppings() {
        return new ArrayList<>(toppings);
    }

    public void addTopping(String topping) {
        if (!toppings.contains(topping)) {
            toppings.add(topping);
        }
    }

    public void removeTopping(String topping) {
        toppings.remove(topping);
    }
}
