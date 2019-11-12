package model;

import datasource.DBFacade;
import java.util.ArrayList;

public class Menu {
    
    private ArrayList<Pizza> pizzaMenuCard = new ArrayList<>();
    private ArrayList<Topping> toppingMenuCard = new ArrayList<>();
    private DBFacade dbFace = new DBFacade();
    
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
