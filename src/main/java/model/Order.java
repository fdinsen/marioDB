package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private ArrayList<Pizza> Pizzas = new ArrayList<>();
    private Customer customer;
    private LocalDateTime pickUpTime;
    private double totalPrice;
    
    //--------------//
    // CONSTRUCTERS //
    //--------------//
    public Order(Customer customer){
        this.customer = customer;
    }
    
    //---------//
    // METHODS //
    //---------//
    public void addExtraTopping(int orderLineId, Topping top){
        Pizzas.get(orderLineId).addExtraTopping(top);
    }
    public void addPizza(Pizza pizz, int size){
        
        
    }
    public void addExtraTopping(Topping top,int orderLineID){
        
        
    }
    private void calculateTotalPrice(){
        
        
    }
    public void removePizzaFromOrder(int orderLineID){
        
        
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
    public LocalDateTime getPickupTime(){
        return pickUpTime;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    
    //---------//
    //ToString //
    //---------//
    @Override
    public String toString(){
        return "";
    }
}
