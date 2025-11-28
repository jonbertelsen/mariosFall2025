import Utilities.FileIO;

import java.util.ArrayList;
import java.util.List;

public class Order {


    public static List<Order> orders = new ArrayList<>();

    private int amount;
    private int pizza_number;
    private int price;
    private String date;

    public Order(int amount, int pizza_number, int price, String date) {
        this.amount = amount;
        this.pizza_number = pizza_number;
        this.price = price;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }
    public int getPizzaNumber() {
        return pizza_number;
    }
    public int getPrice() {
        return price;
    }
    public String getDate() {
        return date;
    }

    public static void addOrders() {
        FileIO file = new FileIO();
        List<String> order = file.readData("data/orders.csv");


        for (String line : order) {
            String[] parts = line.split(",");

            int amount = Integer.parseInt(parts[0]);
            int pizza_number = Integer.parseInt(parts[1]);
            int price = Integer.parseInt(parts[2]);
            String date = parts[3];
            orders.add(new Order(amount, pizza_number, price, date));
        }
    }

    public static int countOrders(){
        int totalPizzas = 0;
        for(Order o: orders){
            totalPizzas += o.getAmount();
        }
        return totalPizzas;
    }


    @Override
    public String toString() {
        return "Order{" + "amount=" + amount + ", pizza_number=" + pizza_number + ", price=" + price + ", date='" + date + '\'' + '}';
    }
}
