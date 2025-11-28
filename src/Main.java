import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String path = "data/menu.csv";
        Menu menu = new Menu(path);  // 1:1 relation, dvs Main / Mario indholder 1 menu
        menu.showMenu();
        Pizza onePizza = menu.getMenuItemById(14); // tester at man kan hente 1 pizza ud af menuen
        System.out.println(onePizza);

        Pizza.addPizza();
        Order.addOrders();

        // Udregn omsætning for hver pizza: først hvor vi bruger et Array til at regne i
        // Fordel med et array som datastruktur: det er enkelt at overskue
        // Ulempe med et array som datastruktur: ikke robust hvis data ændrer sig. Fx tilføjer en pizza som nr. 113

        List<Order> orderList = Order.orders;
        List<Pizza> pizzaList = menu.getPizzas();

        int[] turnOverArray = new int[pizzaList.size() + 1];

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

        // Udregn omsætning for hver pizza: først hvor vi bruger et Map til at regne i:
        // Fordel med et Map som datastruktur: er ikke afhængig af antallet af pizzanumre (som fx et array)
        // Ulempe med et Map som datastruktur: lidt mere komplekst at overskue brug af key, value. Dvs, at det kræver en if / else.

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

        System.out.println("Med Hashmap til at beregne omsætning");
        for (Pizza pizza : pizzaList) {
            System.out.println(pizza.getNumber() +
                    ": " + pizza.getTitle() +
                    ", omsætning: " +
                    turnOverMap.get(pizza.getNumber()) + " kr.");
        }

    }
}
