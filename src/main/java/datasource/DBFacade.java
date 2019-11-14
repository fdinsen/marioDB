package datasource;

import java.util.ArrayList;
import model.Customer;
import model.IndividualStatistics;
import model.Order;
import model.Pizza;
import model.Topping;

public class DBFacade implements DataSource{
    
    @Override
    public ArrayList<Pizza> getAllPizza() {
        return new PizzaMapper().getAllPizzas();
    }

    @Override
    public void insertPizza() {
        new PizzaMapper().insertPizza();
    }

    @Override
    public void removePizza() {
        new PizzaMapper().removePizza();
    }

    @Override
    public ArrayList<Topping> getAllTopping() {
        return new ToppingMapper().getAllToppings();
    }

    @Override
    public void insertTopping() {
        new ToppingMapper().insertTopping();
    }

    @Override
    public void removeTopping() {
        new ToppingMapper().removeTopping();
    }

    @Override
    public ArrayList<Order> getAllActiveOrders(ArrayList<Pizza> pizzas, ArrayList<Topping> toppings) {
        return new ActiveOrderMapper().getActiveOrders(pizzas, toppings);
    }


    @Override
    public void insertOrder(Order ord) {
        new ActiveOrderMapper().insertOrder(ord);
    }

    @Override
    public void removeOrder(int orderId) {
        new ActiveOrderMapper().removeOrder(orderId);
    }

    @Override
    public void insertSavdOrder(Order ord) {
        new SavedOrdersMapper().insertOrder(ord);
    }

    @Override
    public boolean customerExits(int phoneNo) {
        return new CustomerMapper().customerExists(phoneNo);
    }

    @Override
    public Customer getCustomer(int phonoNo) {
        return new CustomerMapper().getCustomer(phonoNo);
    }


    @Override
    public Customer createCustomer(int phoneNo) {
        return new CustomerMapper().createCustomer(phoneNo);
    }
    
    @Override
    public void updateCustomerName(int phoneNo, String name) {
        new CustomerMapper().updateName(phoneNo, name);
    }

    @Override
    public IndividualStatistics getAmountOfOrders() {
        return new StaticsticsMapper().getAmountOfOrder();
    }

    @Override
    public IndividualStatistics getTotalTurnover() {
        return new StaticsticsMapper().getTotalTurnover();
    }

    @Override
    public IndividualStatistics getAverageOrderPrice() {
        return new StaticsticsMapper().getAverageOrderPrice();
    }

    @Override
    public IndividualStatistics getTopSellingPizza() {
        return new StaticsticsMapper().getTopSellingPizza();
    }

    @Override
    public IndividualStatistics getWorstSellingPizza() {
        return new StaticsticsMapper().getWorstSellingPizza();
    }

    @Override
    public ArrayList<IndividualStatistics> getAllPizzaSales() {
        return new StaticsticsMapper().getAllPizzaSales();
    }
    @Override
    public ArrayList<IndividualStatistics> getCustomerOrders(int phoneNo){
        return new StaticsticsMapper().getCustomerOrders(phoneNo);
    }
}
