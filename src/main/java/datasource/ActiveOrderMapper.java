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

public class ActiveOrderMapper {

    private Connection con = null;
    
    public int getActiveOrders() {
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
                orders.add(new Order(new Customer(customerPhone)));
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
