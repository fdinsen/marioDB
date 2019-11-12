package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

public class SavedOrdersMapper {
    Connection con = null;
    
    public static void main(String[] args) {
        SavedOrdersMapper sOM = new SavedOrdersMapper();
        sOM.getSavedOrders();
    }
    
    public ArrayList<Order> getSavedOrders(){
        Statement stmt;
        ArrayList<Order> orders = new ArrayList<>();
        Order order;

        try {
            System.out.println("Test");
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM saved_orders");
            while (rs.next()) {
                int id = rs.getInt("order_id");
                Double price = rs.getDouble("total_price");
                String ord_time = rs.getString("order_time");
                int cus_id = rs.getInt("customer_id");
                //order = new Order(id, name, price);
                //orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void insertOrder(Order ord){
    
    }
}
