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

    public void setPizzaSize(PizzaSize size) {
        this.size = size;
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
    public String getPizzaName() {
        return name;
    }

    public int getPizzaNo() {
        return pizzaNo;
    }
    
    public PizzaSize getPizzaSize(){
        return size;
    }
    
    public String getPizzaSizeString(){
        return size.toString();
    }

    public double getTotalPizzaPrice() {
        return totalPizzaPrice;
    }
    public ArrayList<Integer> getDefaultToppingsID(){
        return defaultToppingsID;
    }

    public ArrayList<Topping> getAllToppingsOnPizza(){return toppings;}
    
    
    
    //---------//
    //ToString //
    //---------//
    @Override
    public String toString(){
        return "";
    }


    public ArrayList<Topping> getToppingsAdded() {
        return extraToppings;
    }
    public String getAllToppings(){
        String returnString = null;
        
        for(Topping top : toppings){
            returnString += top.getToppingName();
        }
        
        
        return returnString;
    }
}
