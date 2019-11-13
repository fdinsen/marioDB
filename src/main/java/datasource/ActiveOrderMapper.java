package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.Customer;
import model.Pizza;
import model.Topping;

public class ActiveOrderMapper {

    private Connection con = null;

    public int getActiveOrders(ArrayList<Pizza> pizzas, ArrayList<Topping> toppings) {
        Statement stmt;
        ArrayList<Order> orders = new ArrayList<>();
        Order order;
        int numberOfOrders = 0;
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rsOrders = stmt.executeQuery("SELECT * FROM active_orders");
            int count = 0;
            while (rsOrders.next()) {
                int orderId;
                double totalPrice;
                int customerPhone;
                orderId = rsOrders.getInt("order_id");
                totalPrice = rsOrders.getDouble("total_price");
                customerPhone = rsOrders.getInt("customer_phone");
                orders.add(new Order(customerPhone));

                ResultSet rsPizza = stmt.executeQuery("SELECT * FROM orderlines_pizzas WHERE order_id = " + count + 1);

                while (rsPizza.next()) {
                    int pizzaId;
                    int pizzaSize;
                    pizzaId = rsPizza.getInt("pizza_id");
                    pizzaSize = rsPizza.getInt("pizza_size");
                    orders.get(count).addPizza(pizzas.get(pizzaId), pizzaSize);
                    int orderlineId = rsPizza.getInt("orderline_id");
                    //TODO use subquery to get all the toppings for this pizza
                    ResultSet rsTopping = stmt.executeQuery("SELECT * FROM orderlines_toppings WHERE orderline_id = " + orderlineId);

                    while(rsTopping.next() ){
                        int toppingId;
                        
                        toppingId = rsTopping.getInt("topping_id");
                        orders.get(count).addExtraTopping(toppings.get(toppingId), orderlineId);
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActiveOrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfOrders;
    }

    public void insertOrder(Order ord) {

    }

    public void removeOrder(int orderId) {

    }
}
