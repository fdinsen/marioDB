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
    private int orderLineID;
    private ArrayList<Integer> defaultToppingsID;

    //--------------//
    // CONSTRUCTERS //
    //--------------//
    public Pizza(int id, String name, int price, ArrayList<Integer> defaultToppingsID) {
        this.name = name;
        this.totalPizzaPrice += price;
        this.pizzaNo = id;
        this.defaultToppingsID = defaultToppingsID;
    }

    //---------//
    // METHODS //
    //---------//
    public void addExtraTopping(Topping top) {
        extraToppings.add(top);
        totalPizzaPrice += top.getToppingPrice();

    }

    public void addTopping(Topping top) {
        toppings.add(top);
    }

    //---------//
    // SETTERS //
    //---------//
    public void setOrderLineID(int id) {
        this.orderLineID = id;
    }

    public void setPizzaSize(PizzaSize size) {
        this.size = size;
    }

    //---------//
    // GETTERS //
    //---------//
    public int geOrderLineID() {
        return orderLineID;
    }

    public String getPizzaName() {
        return name;
    }

    public int getPizzaNo() {
        return pizzaNo;
    }

    public String getPizzaSizeString() {
        return size.toString();
    }

    public double getTotalPizzaPrice() {
        return totalPizzaPrice;
    }

    public ArrayList<Integer> getDefaultToppingsID() {
        return defaultToppingsID;
    }

    public ArrayList<Topping> getAllToppingsOnPizza() {
        return toppings;
    }

    public ArrayList<Topping> getAllExtraToppingsOnPizza() {
        return extraToppings;
    }

    public String getAllToppingsString() {
        StringBuilder returnString = null;
        if (!toppings.isEmpty()) {
            for (Topping top : toppings) {
                returnString.append(top.getToppingName());
                returnString.append(" ");
            }
        }
        if (!extraToppings.isEmpty()) {
            for (Topping top : extraToppings) {
                returnString.append(top.getToppingName()).append(" ");
            }
        }

        return returnString.toString();
    }
}
