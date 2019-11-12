package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Customer;

public class CustomerMapper {
    
    Connection con = null;
    int exits;
    public boolean customerExists(int phonoNo){
        try {
            //String SQL = "SELECT count(*) FROM customer where customer_phone = ?";
            String SQL = "SELECT * FROM customer";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            //ps.setString(1, String.valueOf(phonoNo));
            
            ResultSet rs = ps.executeQuery();
            //int exits = rs.getInt("count(*)");
            while(rs.next()){
                System.out.println(rs.getString("customer_name"));
            }
            System.out.println("hello");
        } catch (SQLException ex) {
            System.out.println("Connection failed"); 
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
