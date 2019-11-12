package datasource;

import java.util.ArrayList;
import model.Customer;
import model.Order;
import model.Pizza;
import model.Topping;

public interface DataSource {
    
    public ArrayList<Pizza> getAllPizza();
    public void insertPizza();
    public void removePizza();
    
    public ArrayList<Topping> getAllTopping();
    public void insertTopping();
    public void removeTopping();
    
    public ArrayList<Order> getAllActiveOrders();
    public void insertOrder();
    public void removeOrder();
    
    public ArrayList<Order> getAllSavedOrders();
    public void insertSavdOrder();
    
    public boolean customerExits(int phoneNo);
    public Customer getCustomer(int phonoNo);
    public Customer createCustomer(int phoneNo, String name);
    
}
