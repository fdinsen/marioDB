package datasource;

import java.util.ArrayList;
import model.Pizza;

/**
 *
 * @author TM
 */
public class DBFacade implements DataSource {
   
    @Override
    public ArrayList<Pizza> getPizzas() {
        return new PizzaMapper().getPizzas();
    }

    @Override
    public void insertPizza(Pizza pizza) {
        new PizzaMapper().insertPizza(pizza);
    }
}
