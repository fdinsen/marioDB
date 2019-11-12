package model;

import datasource.DBFacede;
import java.util.ArrayList;

public class Menu {
    
    private ArrayList<Pizza> pizzaMenuCard = new ArrayList<>();
    private ArrayList<Topping> toppingMenuCard = new ArrayList<>();
    private DBFacede dbFace = new DBFacede();
    
    public Menu(){
        setupToppingCard();
        setupPizzaCard();
    }

    private void setupPizzaCard(){
        pizzaMenuCard= dbFace.getAllPizza();
    }
    private void setupToppingCard(){
        toppingMenuCard = dbFace.getAllTopping();
    }
}
