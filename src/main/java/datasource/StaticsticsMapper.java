package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.IndividualStatistics;

public class StaticsticsMapper {

    private Connection con = null;

    public IndividualStatistics getAmountOfOrder() {
        Statement stmt;
        int sales = 0;
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) from saved_orders");

            rs.next();
            sales = rs.getInt("count(*)");

        } catch (SQLException ex) {
            System.out.println(ex + "Connection failed");
        }

        return new IndividualStatistics(sales);
    }

    public IndividualStatistics getTotalTurnover() {

        Statement stmt;
        double turnOver = 0;
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sum(total_price) from saved_orders");

            rs.next();
            turnOver = rs.getDouble("sum(total_price)");

        } catch (SQLException ex) {
            System.out.println(ex + "Connection failed");
        }

        return new IndividualStatistics(turnOver);
    }

    public IndividualStatistics getAverageOrderPrice() {

        Statement stmt;
        double average = 0;
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT avg(total_price) from saved_orders");

            rs.next();
            average = rs.getDouble("avg(total_price)");

        } catch (SQLException ex) {
            System.out.println(ex + "Connection failed");
        }

        return new IndividualStatistics(average);

    }

    public IndividualStatistics getTopSellingPizza() {

        Statement stmt;
        int sales = 0;
        String name = "";
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pizza_name,count(pizza_name) as count from saved_orders_pizzas group by pizza_name order by count(pizza_name) desc limit 1");

            rs.next();
            name = rs.getString("pizza_name");
            sales = rs.getInt("count");

        } catch (SQLException ex) {
            System.out.println(ex + "Connection failed");
        }

        return new IndividualStatistics(name, sales);

    }

    public IndividualStatistics getWorstSellingPizza() {
        Statement stmt;
        int sales = 0;
        String name = "";
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pizza_name,count(pizza_name) as count from saved_orders_pizzas group by pizza_name order by count(pizza_name) limit 1");

            rs.next();
            name = rs.getString("pizza_name");
            sales = rs.getInt("count");

        } catch (SQLException ex) {
            System.out.println(ex + "Connection failed");
        }

        return new IndividualStatistics(name, sales);
    }

    public ArrayList<IndividualStatistics> getAllPizzaSales() {
        Statement stmt;
        ArrayList<IndividualStatistics> list = new ArrayList<>();
        int sales = 0;
        String name = "";
        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pizza_name,count(pizza_name) as count from saved_orders_pizzas group by pizza_name order by count(pizza_name) desc");

            while (rs.next()) {
                name = rs.getString("pizza_name");
                sales = rs.getInt("count");
                list.add(new IndividualStatistics(name, sales));
            }

        } catch (SQLException ex) {
            System.out.println(ex + "Connection failed");
        }

        return list;
    }

    public ArrayList<IndividualStatistics> getCustomerOrders(int phoneNo) {

        ArrayList<IndividualStatistics> list = new ArrayList<>();
        Statement stmt = null;
        String pizza_name = "";
        String pizza_topping = "";
        int pizza_price = 0;
        String pickup_time = "";

        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pizza_name,pizza_topping,pizza_price,pickup_time,saved_orders.customer_phone from saved_orders natural join saved_orders_pizzas natural join customers where saved_orders.customer_phone = " + phoneNo);

            while (rs.next()) {

                pizza_name = rs.getString("pizza_name");
                pizza_topping = rs.getString("pizza_topping");
                pizza_price = rs.getInt("pizza_price");

                pickup_time = rs.getString("pickup_time");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(pickup_time, formatter);

                list.add(new IndividualStatistics(pizza_name, pizza_topping,dateTime, pizza_price));
                
            }

        } catch (SQLException ex) {
            System.out.println(ex + "connection failed");
        }

        return list;
    }
}
