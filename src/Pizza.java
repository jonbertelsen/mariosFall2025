import Utilities.FileIO;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements Comparable<Pizza> {
    static FileIO file = new FileIO();
    public static List<String> pizza = file.readData("data/menu.csv");
    public static List<Pizza> pizzas = new ArrayList<>();


    private int number;
    private String title;
    private String description;
    private double price;

    public Pizza(int number, String title, String description, double price) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.price = price;
    }
    public int getNumber() {
        return number;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }

    public static void addPizza() {
        for(String line : pizza){
            String[] parts =  line.split(",");

            int number = Integer.parseInt(parts[0]);
            String name = parts[1];
            String description = parts[2];
            double price = Double.parseDouble(parts[3]);

            pizzas.add(new Pizza(number, name, description, price));
        }
    }

    @Override
    public int compareTo(Pizza other){
        return this.number - other.number;
    }

    @Override
    public String toString() {
        return "Pizza{" + "number=" + number + ", title='" + title + '\'' + ", description='" + description + '\'' + ", price=" + price + '}';
    }
}
