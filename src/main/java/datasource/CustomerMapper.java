package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Pizza;

public class CustomerMapper {
    
    Connection con = null;
    int exits;
    Statement stmt;
    
    public boolean customerExists(int phonoNo){
        Statement stmt;
        ArrayList<Pizza> pizzas = new ArrayList<>();
        Pizza pizza;
        
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            System.out.println(rs);
            while(rs.next()){
                System.out.println("1");
                String name = rs.getString("customer_name");
                System.out.println(name);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return exits == 1;
    }
    public Customer getCustomer(int phoneNo){
        return null;
    }
    public Customer createCustomer(int phoneNo, String name){
        return null;
    }
}
