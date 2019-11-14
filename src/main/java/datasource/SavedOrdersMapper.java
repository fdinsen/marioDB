package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Order;
import model.Pizza;

public class SavedOrdersMapper {
    Connection con = null;
    
    public void insertOrder(Order ord){
        
        try{
            
            String SQL = "INSERT into saved_orders (total_price, pickup_time, customer_phone) VALUES (?, ? , ?)";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, ord.getTotalPrice());
            ps.setString(2, ord.getPickupTime().toString());
            ps.setInt(3,ord.getCustomer().getPhoneNo());
            
            ps.execute();
            
            ResultSet ids = ps.getGeneratedKeys();
            
            SQL = "INSERT into saved_orders_pizzas (saved_order_id, pizza_name, pizza_topping, pizza_price) VALUES (?,?,?,?)";
            ps = con.prepareStatement(SQL);
            ids.next();
            int id = ids.getInt(1);
            
            for(Pizza piz : ord.getAllPizzasOnOrder()){
                ps.setInt(1, id);
                ps.setString(2,piz.getPizzaName());
                ps.setString(3,piz.getAllToppingsString());
                ps.setDouble(4, piz.getTotalPizzaPrice());
                
                ps.execute();
            }
            ps.close();
            
        }catch (SQLException ex){
            System.out.println(ex + "connection failed");
        }
    }
}
