package datasource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Pizza;

/**
 *
 * @author TM
 */
public class FileHandler implements DataSource {

    private static final String FILE_NAME = "menu.txt";

    @Override
    public ArrayList<Pizza> getPizzas() {
        ArrayList<Pizza> pizzas = new ArrayList();
        Pizza pizza;
        String[] tmp;
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNext()) {
                tmp = scanner.nextLine().split(" ");
                int id = Integer.parseInt(tmp[0]);
                int price = Integer.parseInt(tmp[3]);
                pizza = new Pizza(id, tmp[1], tmp[2], price);
                pizzas.add(pizza);
            }
        } catch (FileNotFoundException ex) {
        }
        return pizzas;
    }

    @Override
    public void insertPizza(Pizza pizza) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
