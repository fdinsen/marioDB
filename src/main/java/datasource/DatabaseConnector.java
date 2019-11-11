package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of Connector is to connect to the database
 * Class is implemented as Singleton design pattern
 * @see https://en.wikipedia.org/wiki/Singleton_pattern
 * @see https://en.wikipedia.org/wiki/Single_responsibility_principle
 * @author TM
 */
public class DatabaseConnector {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mario";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection con = null;

    private DatabaseConnector() {        
    }
    
    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }

    public static void main(String[] args) {
        new DatabaseConnector().getConnection();
    }
}
