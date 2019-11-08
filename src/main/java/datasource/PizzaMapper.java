package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pizza;

/**
 * Pattern: Data Mapper 
 * The purpose of PizzaMapper is to retrieve rows of pizzas
 * from the database and map to Pizza objects
 *
 * @see https://www.martinfowler.com/eaaCatalog/dataMapper.html
 * @author TM
 */
public class PizzaMapper {

    Connection con = null;
    
    public ArrayList<Pizza> getPizzas() {
        Statement stmt;
        ArrayList<Pizza> pizzas = new ArrayList();
        Pizza pizza;

        try {
            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pizzas");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                pizza = new Pizza(id, name, description, price);
                pizzas.add(pizza);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pizzas;
    }

    public void insertPizza(Pizza pizza) {
        try {
            String SQL = "INSERT INTO pizzas (name, description, price) VALUES (?, ?, ?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pizza.getName());
            ps.setString(2, pizza.getDescription());
            ps.setInt(3, pizza.getPrice());
            ps.executeUpdate();
            
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            pizza.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        PizzaMapper pm = new PizzaMapper();
//        Pizza ny = new Pizza("Carbona","tomatsauce, cocktailpølser, ost", 60);
//        pm.insertPizza(ny);
        ArrayList<Pizza> searchResult = pm.getPizzas();
        for (Pizza pizza : searchResult) {
            System.out.println(pizza);
        }
    }
}
