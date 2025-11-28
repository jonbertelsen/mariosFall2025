import Utilities.FileIO;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Pizza> pizzas;   // 1:mange, dvs, at 1 menu har mange pizzaer i sig
    private FileIO fileUtil = new FileIO();

    public Menu(String path) {
        pizzas = new ArrayList<>();
        readPizzas(path);

    }

    private void readPizzas(String url){
        List<String> menuItems =  fileUtil.readData(url);

        for(String line : menuItems){
            String[] parts =  line.split(",");

            int number = Integer.parseInt(parts[0]);
            String name = parts[1];
            String description = parts[2];
            double price = Double.parseDouble(parts[3]);

            pizzas.add(new Pizza(number, name, description, price));
        }
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public Pizza getMenuItemById(int pizzaid){
        for (Pizza pizza : pizzas){
            if (pizza.getNumber() == pizzaid){
                return pizza;
            }
        }
        return null;
    }

    public void showMenu(){
        System.out.println("***** Marios Menu ******");
        for (Pizza pizza : pizzas){
            System.out.println(pizza.getNumber() + ": " +
                    pizza.getTitle() + ", " +
                    pizza.getDescription() + ", " +
                    pizza.getPrice() + " kr.");
        }
    }

}
