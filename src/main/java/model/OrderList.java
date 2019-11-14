package model;

import java.util.ArrayList;

public class OrderList {

    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private ArrayList<Order> activeOrders;
    private final Controller controller;

    //--------------//
    // CONSTRUCTOR //
    //--------------//
    OrderList(Controller controller, Menu menu){
        this.controller = controller;
        activeOrders = controller.getAllActiveOrders(menu.getAllPizzas(),menu.getAllToppings());
    }

    //---------//
    // GETTERS //
    //---------//
    public Order getOrder(int orderListIndex){
        return activeOrders.get(orderListIndex-1);
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

    public String getCustomerName(int index) {
        return  activeOrders.get(index-1).getCustomerName();
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
    
    //---------//
    // SETTERS //
    //---------//
    public void setCustomerName(String name, int pos){
        activeOrders.get(pos-1).setCustomerName(name);
    }

    //---------//
    // METHODS //
    //---------//
    public void completeOrder(int index){
        int orderID = activeOrders.get(index-1).getOrderID();
        
        controller.removeOrder(orderID);
        controller.createSavedOrder(activeOrders.get(index-1));
        
        activeOrders.remove(index-1);
    }

    public int createOrder(Customer customer){
        activeOrders.add((new Order(customer)));
        return activeOrders.size();
    }

    public void deleteOrder(int index){
        int orderID = activeOrders.get(index-1).getOrderID();
        controller.removeOrder(orderID);
        
        activeOrders.remove(index-1);
    }

    public void deletePizzaFromOrder(int index, int pizzaNumber) {
        int orderID = activeOrders.get(index-1).getOrderID();
        int pizzaID = activeOrders.get(index-1).getPizzaOrderLineID(pizzaNumber);
        controller.removePizzaFromOrder(orderID, pizzaID);
    }

    public boolean doesHaveCustomerPhone(int index) {
        return getOrder(index).getCustomerPhone() != 00000000;
    }

    public boolean doesHaveCustomerName(int index) {
        return activeOrders.get(index-1).hasName;
    }

    public void addExtraTopping(int orderArrayPosition, int pizzaPos, Topping topping) {
        activeOrders.get(orderArrayPosition-1).addExtraTopping(pizzaPos, topping);
    }
}