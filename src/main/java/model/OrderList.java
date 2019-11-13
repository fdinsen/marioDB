package model;

import java.util.ArrayList;
import datasource.DataSource;
import model.Customer;
import model.Controller;

public class OrderList {
    
    private ArrayList<Order> activeOrders;
    private final Controller controller;
    
    public OrderList(Controller controller,Menu menu){
        this.controller = controller;
        activeOrders = controller.getAllActiveOrders(menu.getAllPizzas(),menu.getAllToppings());
    }
    public void completeOrder(int index){
        
        
    }
    //TODO Creates order returnes orderlistIndex
    public int createOrder(Customer customer){
        activeOrders.add((new Order(customer)));
        return activeOrders.size()-1;
    }
    public void deleteOrder(int orderNo){
        controller.removeOrder(orderNo-1);
        
    }
    public void finishOrder(int orderListIndex){
        
        
    }

    public Order getOrder(int orderListIndex){
        return activeOrders.get(orderListIndex);

    }
    
    public int getOrdersListSize(){
        return activeOrders.size();
    }
    
    public ArrayList<Order> getActiveOrders(){
        return activeOrders;
    }
    
    public ArrayList<Pizza> getAllPizzasInOrder(int index){
       return  activeOrders.get(index-1).getAllPizzasOnOrder();
    }
    
    public int getPizzaCountOnOrder(int index){
       return  activeOrders.get(index-1).getAllPizzasOnOrder().size();
    }



    public void deletePizzaFromOrder(int orderNumber, int pizzaNumber) {
        controller.removePizza(orderNumber, pizzaNumber);
    }

    public String getCustomerName(int index) {
       return  activeOrders.get(index-1).getCustomerName();
    }
    

    public boolean isOrderedByPhone(int index) {
        return false;
    }

    public int getCustomerPhone(int index) {
        return activeOrders.get(index-1).getCustomerPhone();
    }

    public String getPickUpTimeHour(int index) {
        return activeOrders.get(index-1).getPickupTimeHour();
    }
    
    public String getPickUpTimeMinute(int index) {
        return activeOrders.get(index-1).getPickupTimeMinute();
    }

    public void completeOrder(int i, boolean lostOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getTotalPrice(int index) {
        return activeOrders.get(index-1).getTotalPrice();
    }

    public void addExtraTopping(int orderArrayPosition, int pizzaPos, Topping topping) {
        activeOrders.get(orderArrayPosition).addExtraTopping(pizzaPos, topping);
    }
}