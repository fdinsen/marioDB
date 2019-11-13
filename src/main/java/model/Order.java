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
        pickUpTime = LocalDateTime.now().plusMinutes(15);
        //TODO ADD ITSELF TO THE DB
    }
    
    //---------//
    // METHODS //
    //---------//
    
    public void addPizza(Pizza pizz, PizzaSize size){
        //TODO Copy pizza
        Pizza pizza = pizz;
        pizza.setPizzaSize(size);
        pizzas.add(pizza);
    }
    public void addExtraTopping(int orderLineID,Topping top){
        orderLineID = orderLineID;

        pizzas.get(orderLineID).addExtraTopping(top);

        calculateTotalPrice();
        
    }
    private void calculateTotalPrice(){
        totalPrice = 0;
        for (Pizza pizza : pizzas) {
            totalPrice += pizza.getTotalPizzaPrice();
        }
        
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
        return customer.getPhoneNo();
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
    
    public ArrayList<Pizza> getAllPizzasOnOrder(){
        return pizzas;
    }
    
    //---------//
    //ToString //
    //---------//
    @Override
    public String toString(){
        return "";
    }


    public String getCustomerName() {
       return  customer.getCustomerName();
    }
}
