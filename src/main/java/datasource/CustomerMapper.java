package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Customer;

public class CustomerMapper {

    private Connection con = null;
    private int count;
    private Statement stmt;

    private String name;
    private int phoneNo;

    public boolean customerExists(int phonoNo) {
        try {
            String SQL = "SELECT count(*) FROM customers where customer_phone = ?";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, String.valueOf(phonoNo));

            ResultSet rs = ps.executeQuery();

            rs.next();
            count = rs.getInt("count(*)");
            
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex + " Connection failed");
        }
        return count == 1;
    }

    public Customer getCustomer(int phoneNo) {
        Customer cust = null;

        try {
            String SQL = "SELECT customer_name,customer_phone FROM mario.customers where customer_phone = ?";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, phoneNo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                name = rs.getString("customer_name");
                this.phoneNo = rs.getInt("customer_phone");

                cust = new Customer(phoneNo);

                if (!"".equals(name)) {
                    cust.setCustomerName(name);
                }
                ps.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex + " Connection failed");
        }
        return cust;
    }

    public Customer createCustomer(int phoneNo) {
        try {
            String SQL = "INSERT into customers (customer_phone) VALUES ( ?) ";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setInt(1,phoneNo);
            
            ps.execute();
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex + " Connection failed");
        }
        return new Customer(phoneNo);
    }
    public void updateName(int phoneNo){
        try{
            
            
        }catch(SQLException ex){
            System.out.println(ex + " connection failed");
        }
        
        
        
    }
}
