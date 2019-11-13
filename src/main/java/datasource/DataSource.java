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
    
    public ArrayList<Order> getAllActiveOrders(ArrayList<Pizza> pizzas, ArrayList<Topping> toppings);
    public void insertOrder(Order rod);
    public void removeOrder(int orderId);
    
    public ArrayList<Order> getAllSavedOrders();
    public void insertSavdOrder(Order ord);
    
    public boolean customerExits(int phoneNo);
    public Customer getCustomer(int phonoNo);
    public Customer createCustomer(int phoneNo);
    
}
