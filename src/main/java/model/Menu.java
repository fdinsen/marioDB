package model;

import datasource.DataSource;
import java.util.ArrayList;

public class Menu {

    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private ArrayList<Pizza> pizzaMenuCard;
    private ArrayList<Topping> toppingMenuCard;

    //--------------//
    // CONSTRUCTERS //
    //--------------//
    public Menu(DataSource dbSource){
        pizzaMenuCard = dbSource.getAllPizza();
        toppingMenuCard = dbSource.getAllTopping();
        setDefaultToppings();
    }

    //---------//
    // GETTERS //
    //---------//
    public int getAmountOfPizzas(){
        return pizzaMenuCard.size();
    }

    public int getAmountOfToppings(){
        return pizzaMenuCard.size();
    }

    public Pizza getPizza(int i){
        return pizzaMenuCard.get(i-1);
    }

    public Topping getTopping(int i){
        return toppingMenuCard.get(i-1);
    }

    public ArrayList<Topping> getAllToppings(){
        return toppingMenuCard;
    }

    public ArrayList<Pizza> getAllPizzas() {
        return pizzaMenuCard;
    }

    //---------//
    // SETTERS //
    //---------//
    private void setDefaultToppings(){
        for (Pizza pizza : pizzaMenuCard) {
            for(int i : pizza.getDefaultToppingsID()){
                pizza.addTopping(toppingMenuCard.get(i-1));
            }
        }
    }
}
