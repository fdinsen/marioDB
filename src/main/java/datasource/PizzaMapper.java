package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pizza;

public class PizzaMapper  {
    private Connection con = null;

    public PizzaMapper(){

    }
    
    public ArrayList<Pizza> getAllPizzas(){
        Statement stmt;
        ArrayList<Pizza> pizzas = new ArrayList<>();
        Pizza pizza;
        
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pizzas");

            while (rs.next()) {
                int id = rs.getInt("pizza_id");
                String name = rs.getString("pizza_name");
                int price = rs.getInt("pizza_price");
                
                pizza = new Pizza(id, name, price, getDefaultToppingsForPizza(id));
                pizzas.add(pizza);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pizzas;
    }
    public void insertPizza(){
        //TODO create if time is with us
        
    }
    public void removePizza(){
        //TODO create if time is with us
        
    }

    private ArrayList<Integer> getDefaultToppingsForPizza(int id) {
        Statement stmt;
        ArrayList<Integer> defaultToppingsID = new ArrayList<>();
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pizza_toppings where pizza_id = " + id);

            while (rs.next()) {
                int toppingID = rs.getInt("toppings_id");
                defaultToppingsID.add(toppingID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defaultToppingsID;
    }
    
}
