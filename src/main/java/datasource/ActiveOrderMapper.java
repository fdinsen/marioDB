package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.Customer;
import model.Pizza;
import model.PizzaSize;
import model.Topping;

public class ActiveOrderMapper {

    private Connection con = null;

    public ArrayList<Order> getActiveOrders(ArrayList<Pizza> pizzas, ArrayList<Topping> toppings) {
        Statement stmt;
        ArrayList<Order> orders = new ArrayList<>();
        //Order order;
        //int numberOfOrders = 0;
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
                orders.add(new Order(new CustomerMapper().getCustomer(customerPhone)));

                ResultSet rsPizza = stmt.executeQuery("SELECT * FROM orderlines_pizzas WHERE order_id = " + count + 1);

                while (rsPizza.next()) {
                    int pizzaId;
                    int pizzaSize;
                    pizzaId = rsPizza.getInt("pizza_id");
                    pizzaSize = rsPizza.getInt("pizza_size");
                    PizzaSize psize;
                    switch (pizzaSize) {
                        case 1:
                            psize = PizzaSize.FAMILY;
                        case 2:
                            psize = PizzaSize.DEPPAN;
                        default:
                            psize = PizzaSize.NORMAL;
                    }
                    orders.get(count).addPizza(pizzas.get(pizzaId), psize);
                    int orderlineId = rsPizza.getInt("orderline_id");
                    //TODO use subquery to get all the toppings for this pizza
                    ResultSet rsTopping = stmt.executeQuery("SELECT * FROM orderlines_toppings WHERE orderline_id = " + orderlineId);

                    while (rsTopping.next()) {
                        int toppingId;

                        toppingId = rsTopping.getInt("topping_id");
                        orders.get(count).addExtraTopping(toppings.get(toppingId), orderlineId);
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActiveOrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public void insertOrder(Order ord) {
        con = DBConnector.getConnection();
        String SQL = "INSERT INTO active_orders (total_price, pickup_time, customer_phone) "
                + "VALUES (?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, ord.getTotalPrice());
            ps.setString(2, ord.getPickupTime().toString());
            ps.setInt(3, ord.getCustomerPhone());
            ps.execute();
            ResultSet orderId = ps.getGeneratedKeys();
            ps.close();
            for (Pizza pizza : ord.getAllPizzasOnOrder()) {
                SQL = "INSERT INTO orderlines_pizzas (order_id, pizza_id) VALUES (?, ?)";
                ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                int currentOrderId = orderId.getInt("order_id");
                ps.setInt(1, currentOrderId);
                ps.setInt(2, pizza.getPizzaNo());
                ps.execute();
                ResultSet orderlineId = ps.getGeneratedKeys();
                ps.close();
                for (Topping topping : pizza.getToppingsAdded()) {
                    SQL = "INSERT INTO orderlines_toppings (orderline_id, topping_id, order_id) VALUES (?, ?, ?)";
                    ps = con.prepareStatement(SQL);
                    ps.setInt(1, orderlineId.getInt("orderline_id"));
                    ps.setInt(2, topping.getToppingId());
                    ps.setInt(3, currentOrderId);
                    ps.execute();
                    ps.close();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActiveOrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeOrder(int orderId) {
        con = DBConnector.getConnection();
        String SQL = "DELETE FROM active_orders, orderlines_pizzas, orderlines_toppings WHERE order_id = ?";
        try (PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setInt(1, orderId);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ActiveOrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
