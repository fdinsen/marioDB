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
import model.Pizza;
import model.PizzaSize;
import model.Topping;

class ActiveOrderMapper {

    private Connection con = null;

    ArrayList<Order> getActiveOrders(ArrayList<Pizza> pizzas, ArrayList<Topping> toppings) {
        Statement stmt;
        ArrayList<Order> orders = new ArrayList<>();
        //Order order;
        //int numberOfOrders = 0;
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rsOrders = stmt.executeQuery("SELECT * FROM active_orders");
            int orderCounter = 0;
            while (rsOrders.next()) {
                int orderId;
                double totalPrice;
                int customerPhone;
                orderId = rsOrders.getInt("order_id");
                totalPrice = rsOrders.getDouble("total_price");
                customerPhone = rsOrders.getInt("customer_phone");
                orders.add(new Order(new CustomerMapper().getCustomer(customerPhone)));
                orders.get(orderCounter).setOrderID(orderId);
                Statement stmt2 = con.createStatement();
                ResultSet rsPizza = stmt2.executeQuery("SELECT * FROM orderlines_pizzas WHERE order_id = " + orderId);
                int pizzaCounter = 0;
                while (rsPizza.next()) {
                    int pizzaId;
                    int pizzaSize;
                    pizzaId = rsPizza.getInt("pizza_id");
//                    PizzaSize psize = PizzaSize.NORMAL;
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
                    orders.get(orderCounter).addPizza(pizzas.get(pizzaId-1), psize);
                    int orderlineId = rsPizza.getInt("orderline_id");
                    orders.get(orderCounter).getAllPizzasOnOrder().get(pizzaCounter).setOrderLineID(orderlineId);
                    //TODO use subquery to get all the toppings for this pizza

                    Statement stmt3 = con.createStatement();
                    ResultSet rsTopping = stmt3.executeQuery("SELECT * FROM orderlines_toppings WHERE orderline_id = " + orderlineId);
                    while (rsTopping.next()) {
                        int toppingId;

                        toppingId = rsTopping.getInt("topping_id");
                        orders.get(orderCounter).addExtraTopping(pizzaCounter, toppings.get(toppingId-1));
                    }
                    pizzaCounter++;
                    rsTopping.close();
                    stmt3.close();
                }
                rsPizza.close();
                stmt2.close();
                orderCounter++;
            }
            rsOrders.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActiveOrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    void insertOrder(Order ord) {
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
            int currentOrderId = 0;
            if (orderId.next()) {
                currentOrderId = orderId.getInt(1);
                ord.setOrderID(currentOrderId);
            }
            ps.close();
            for (Pizza pizza : ord.getAllPizzasOnOrder()) {
                SQL = "INSERT INTO orderlines_pizzas (order_id, pizza_id) VALUES (?, ?)";
                ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, currentOrderId);
                ps.setInt(2, pizza.getPizzaNo());
                ps.execute();
                ResultSet orderlineId = ps.getGeneratedKeys();
                int currentOrderlineId = 0;
                if (orderlineId.next()) {
                    currentOrderlineId = orderlineId.getInt(1);
                    pizza.setOrderLineID(currentOrderlineId);
                }
                ps.close();
                for (Topping topping : pizza.getAllExtraToppingsOnPizza()) {
                    SQL = "INSERT INTO orderlines_toppings (orderline_id, topping_id, order_id) VALUES (?, ?, ?)";
                    ps = con.prepareStatement(SQL);
                    ps.setInt(1, currentOrderlineId);
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

    void removeOrder(int orderId) {
        con = DBConnector.getConnection();
        //TODO Find sql statement that deletes all rows on order_id, right now there needs to be an order_id that matches in every table..
//        String SQL = "DELETE FROM a,b USING active_orders a JOIN orderlines_pizzas WHERE a.order_id = ?";
//        try (PreparedStatement ps = con.prepareStatement(SQL)) {
//            ps.setInt(1, orderId);
//            ps.execute();
//        } catch (SQLException ex) {
//            System.out.println("SQL ERROR AT ActiveOrderMapper -> removeOrder()");
//            Logger.getLogger(ActiveOrderMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        String SQL = "SELECT count(*) FROM orderlines_toppings WHERE order_id = ?";
        try (PreparedStatement psCount = con.prepareStatement(SQL)) {
            psCount.setInt(1, orderId);
            ResultSet count = psCount.executeQuery();
            if (count.next()) {
               SQL =  "DELETE FROM a,b,c USING active_orders a JOIN orderlines_pizzas b JOIN orderlines_toppings c WHERE a.order_id = ?";
            }
            else {
                SQL = "DELETE FROM a,b USING active_orders a JOIN orderlines_pizzas WHERE a.order_id = ?";
            }
            try (PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setInt(1, orderId);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("SQL ERROR AT ActiveOrderMapper -> removeOrder()");
            Logger.getLogger(ActiveOrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        }catch (SQLException ex) {
            System.out.println("SQL ERROR AT ActiveOrderMapper -> removeOrder()");
            Logger.getLogger(ActiveOrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
