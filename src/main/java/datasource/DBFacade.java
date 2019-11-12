package datasource;

import java.util.ArrayList;
import model.Customer;
import model.Order;
import model.Pizza;
import model.Topping;

public class DBFacade implements DataSource{

    
    
    @Override
    public ArrayList<Pizza> getAllPizza() {
        return null;
    }

    @Override
    public void insertPizza() {
    }

    @Override
    public void removePizza() {
    }

    @Override
    public ArrayList<Topping> getAllTopping() {
        return null;
    }

    @Override
    public void insertTopping() {
    }

    @Override
    public void removeTopping() {
    }

    @Override
    public ArrayList<Order> getAllActiveOrders() {
        return null;
    }

    @Override
    public void insertOrder() {
    }

    @Override
    public void removeOrder() {
    }

    @Override
    public ArrayList<Order> getAllSavedOrders() {
        return null;
    }

    @Override
    public void insertSavdOrder() {
    }

    @Override
    public boolean customerExits(int phoneNo) {
        return false;
    }

    @Override
    public Customer getCustomer(int phonoNo) {
        return null;
    }

    @Override
    public Customer createCustomer(int phoneNo, String name) {
        return null;
    }

}
