import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String path = "data/menu.csv";
        Menu menu = new Menu(path);  // 1:1 relation, dvs Main / Mario indholder 1 menu
        menu.showMenu();
        Pizza pizza = menu.getMenuItemById(14);
        System.out.println(pizza);

/*
        Pizza.addPizza();
        Order.addOrders();

        // Udregn omsætning for hver pizza:

        List<Order> orderList = Order.orders;

        Map<Integer, Integer> turnOverMap = new HashMap<>();

        for (Order order : orderList) {
            if (turnOverMap.containsKey(order.getPizzaNumber())) {
                int turnOver = turnOverMap.get(order.getPizzaNumber());
                int newTurnOver = turnOver + order.getAmount() * order.getPrice();
                turnOverMap.put(order.getPizzaNumber(), newTurnOver);
            } else {
                turnOverMap.put(order.getPizzaNumber(), order.getAmount() * order.getPrice());
            }
        }

        System.out.println("Med Hashmap til at beregne somsætning");

        List<Pizza> pizzaList = Pizza.pizzas;
        for (Pizza pizza : pizzaList) {
            System.out.println(pizza.getNumber() +
                    ": " + pizza.getTitle() +
                    ", omsætning: " +
                    turnOverMap.get(pizza.getNumber()) + " kr.");
        }

        int[] turnOverArray = new int[pizzaList.size() + 100];

        for (Order order : orderList) {
            int turnOver = turnOverArray[order.getPizzaNumber()];
            int turnOverToAdd = order.getAmount() * order.getPrice();
            turnOverArray[order.getPizzaNumber()] = turnOver + turnOverToAdd;
        }

        System.out.println("Med Array til at beregne somsætning");
        for (Pizza pizza : pizzaList) {
            System.out.println(pizza.getNumber() +
                    ": " + pizza.getTitle() +
                    ", omsætning: " +
                    turnOverArray[pizza.getNumber()] + " kr.");
        }

*/

    }
}
