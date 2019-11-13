package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private Customer customer;
    private LocalDateTime pickUpTime;
    private double totalPrice;
    
    //--------------//
    // CONSTRUCTERS //
    //--------------//
    public Order(Customer customer){
        this.customer = customer;
        //TODO ADD ITSELF TO THE DB
    }
    
    //---------//
    // METHODS //
    //---------//
    public void addExtraTopping(int orderLineId, Topping top){
        pizzas.get(orderLineId).addExtraTopping(top);
    }
    
    public void addPizza(Pizza pizz, PizzaSize size){
        //TODO Copy pizza
        Pizza pizza = pizz;
        pizza.setPizzaSize(size);
        pizzas.add(pizza);
    }
    public void addExtraTopping(Topping top,int orderLineID){
        
        
    }
    private void calculateTotalPrice(){
        
        
    }
    public void removePizzaFromOrder(int orderLineID){
        
        
    }
    //---------//
    // SETTERS //
    //---------//
    public void setCustomerName(String name){
        this.customer.setCustomerName(name);
    }

    //---------//
    // GETTERS //
    //---------//
    public Pizza getPizza(int index){
        return null;
    }
    public Customer getCustomer(){
        return customer;
    }
    public int getCustomerPhone(){
        return customer.getPhoneNumber();
    }
    
    public LocalDateTime getPickupTime(){
        return pickUpTime;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public int getAmountOfPizzasOnOrder(){
        return pizzas.size();
    }
    
    public String getPickupTimeHour() {
        return "" + pickUpTime.getHour();
    }

    public String getPickupTimeMinute() {
        return "" + pickUpTime.getMinute();
    }
    
    //---------//
    //ToString //
    //---------//
    @Override
    public String toString(){
        return "";
    }

    public void addExtraTopping(int pizzaPos, int i, int extraQuantitySelection) {
    }

    public ArrayList<Pizza> getPizzasOnOrder() {
        return pizzas;
    }
}
