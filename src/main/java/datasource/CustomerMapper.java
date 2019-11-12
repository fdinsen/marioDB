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
    int count;
    Statement stmt;
    
    public boolean customerExists(int phonoNo){
        try {
            String SQL = "SELECT count(*) FROM customers where customer_phone = ?";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, String.valueOf(phonoNo));
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            count = rs.getInt("count(*)");
            
        } catch (SQLException ex) {
            System.out.println(ex+" Connection failed");
        }
        return count == 1;
    }
    public Customer getCustomer(int phoneNo){
        try{
            String SQL = "SELECT ";
        }catch (SQLException ex){
            System.out.println(ex+ " Connection failed");
        }
        
        
        
        
    }
    public Customer createCustomer(int phoneNo, String name){
        return null;
    }
}
