package model;
import datasource.DataSource;
import java.util.ArrayList;
import ui.UI;

public class Controller {
    
    private final DataSource datasource;
    private final UI ui;
    private final Menu menu;
    private final OrderList orderlist;
    
    public Controller(DataSource datasource, UI ui){
        this.datasource = datasource;
        this.ui = ui;
        menu = new Menu(datasource);
        orderlist = new OrderList(this, menu);
        startProgram();
    }
    
    public void startProgram() {
        ui.startUI(this,menu,orderlist);
    }
    
    public void updateCustomerName(int phoneNo, String name) {
        datasource.updateCustomerName(phoneNo, name);
    }
    public boolean checkIfCustomerExists(int phoneNo){
        return datasource.customerExits(phoneNo);
    }
    public Customer createCustomer(int phoneNo){
        return datasource.createCustomer(phoneNo);
    }
    
    public Customer getCustomer(int phone){
        return datasource.getCustomer(phone);
    }
    
    public void createActiveOrder(Order order){
        datasource.insertOrder(order);
    }

    ArrayList<Order> getAllActiveOrders(ArrayList<Pizza> allPizzas, ArrayList<Topping> allToppings) {
        return datasource.getAllActiveOrders(allPizzas, allToppings);
    }

    void removePizza(int orderNumber, int pizzaNumber) {
        //TODO add function
        //datasource.removePizza(orderNumber,pizzaNumber);
    }

    void removeOrder(int orderNo) {
        datasource.removeOrder(orderNo);
    }
}
