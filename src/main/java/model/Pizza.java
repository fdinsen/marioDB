package model;

import java.util.ArrayList;

public class Pizza {
    
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private ArrayList<Topping> toppings = new ArrayList<>();
    private ArrayList<Topping> extraToppigns = new ArrayList<>();
    private String name;
    private PizzaSize size;
    private int pizzaNo;
    private double totalPizzaPrice;
    
    //--------------//
    // CONSTRUCTERS //
    //--------------//
    public Pizza(){
        
    }
    
    //---------//
    // METHODS //
    //---------//
    public void addExtraTopping(Topping top){
        extraToppigns.add(top);
    }
    //---------//
    // GETTERS //
    //---------//
    public Topping getTopping(int index){
        return toppings.get(index);
    }
    public Topping getExtraTopping(int index){
        return extraToppigns.get(index);
    }
    public String getName() {
        return name;
    }

    public int getPizzaNo() {
        return pizzaNo;
    }

    public double getTotalPizzaPrice() {
        return totalPizzaPrice;
    }
    //---------//
    //ToString //
    //---------//
    @Override
    public String toString(){
        return "";
    }
}
