package model;

import datasource.DataSource;
import java.util.ArrayList;

public class Menu {
    
    private ArrayList<Pizza> pizzaMenuCard = new ArrayList<>();
    private ArrayList<Topping> toppingMenuCard = new ArrayList<>();
    private DataSource datasource;
    
    
    public Menu(DataSource dbSource){
        this.datasource = dbSource;
        pizzaMenuCard = datasource.getAllPizza();
        toppingMenuCard = datasource.getAllTopping();
        setDefaultToppings();
    }
    
    private void setDefaultToppings(){
        for (Pizza pizza : pizzaMenuCard) {
            for(int i : pizza.getDefaultToppingsID()){
                pizza.addTopping(toppingMenuCard.get(i-1));
            }
        }
    }
    
    public int getNumberOfPizzas(){
        return pizzaMenuCard.size();
    }
    
    public Pizza getPizza(int i){
        return pizzaMenuCard.get(i-1);
    }
    
    public Topping getTopping(int i){
        return toppingMenuCard.get(i-1);
    }
}
