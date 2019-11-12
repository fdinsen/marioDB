package model;

public class Topping {
    
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private String name;
    private double price;
    
    //--------------//
    // CONSTRUCTERS //
    //--------------//
    public Topping(){
        
    }
    
    //---------//
    // GETTERS //
    //---------//
    public String getToppingName(){
        return name;
    }
    public double getToppingPrice(){
        return price;
    }
    
    //---------//
    //ToString //
    //---------//
    @Override
    public String toString(){
        return "";
    }
}
