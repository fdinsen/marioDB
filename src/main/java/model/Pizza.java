package model;

import java.util.ArrayList;

public class Pizza {
    
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private ArrayList<Topping> toppings = new ArrayList<>();
    private ArrayList<Topping> extraToppings = new ArrayList<>();
    private String name;
    private PizzaSize size;
    private int pizzaNo;
    private double totalPizzaPrice;
    private ArrayList<Integer> defaultToppingsID;
    
    //--------------//
    // CONSTRUCTERS //
    //--------------//
    public Pizza(int id, String name, int price,ArrayList<Integer> defaultToppingsID){
        this.name = name;
        this.totalPizzaPrice += price;
        this.pizzaNo = id;
        this.defaultToppingsID = defaultToppingsID;
    }
    
    //---------//
    // METHODS //
    //---------//
    public void addExtraTopping(Topping top){
        extraToppings.add(top);
    }
    
    public void addTopping(Topping top){
        toppings.add(top);
    }
    //---------//
    // GETTERS //
    //---------//
    public Topping getTopping(int index){
        return toppings.get(index);
    }
    public Topping getExtraTopping(int index){
        return extraToppings.get(index);
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
    public ArrayList<Integer> getDefaultToppingsID(){
        return defaultToppingsID;
    }
    
    //---------//
    //ToString //
    //---------//
    @Override
    public String toString(){
        return "";
    }
}
