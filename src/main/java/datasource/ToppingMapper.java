package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Topping;

public class ToppingMapper  {
    Connection con = null;

    public ToppingMapper(){
        
        
    }

    public ArrayList<Topping> getAllToppings(){
        Statement stmt;
        ArrayList<Topping> toppings = new ArrayList<>();
        Topping topping;

        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM toppings");

            while (rs.next()) {
                int id = rs.getInt("toppings_id");
                String name = rs.getString("topping_name");
                int price = rs.getInt("topping_price");
                topping = new Topping(id, name, price);
                toppings.add(topping);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toppings;
    }

    public void insertTopping(){
        //TODO create if time is with us
        
    }
    public void removeTopping(){
        //TODO create if time is with us
        
    }
    
}
