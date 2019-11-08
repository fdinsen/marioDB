package datasource;

import java.util.ArrayList;
import model.Pizza;

/**
 *
 * @author TM
 */
public interface DataSource {
    
    public ArrayList<Pizza> getPizzas();
    public void insertPizza(Pizza pizza);
}
