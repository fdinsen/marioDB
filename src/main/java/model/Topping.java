package model;

public class Topping {
    
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private String name;
    private double price;
    private int id;
    
    //--------------//
    // CONSTRUCTOR //
    //--------------//
    public Topping(){
        
    }

    public Topping(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
    public int getToppingId() {
        return id;
    }

}
