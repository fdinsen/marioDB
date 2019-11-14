/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import datasource.DBFacade;
import datasource.DataSource;
import factory.DataSourceFactory;
import factory.DataSources;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olvvang
 */
public class MenuTest {
    Menu menu;
    public MenuTest() {
        DataSource source = new DBFacade();
        menu = new Menu(source);
    }
    @Test
    public void testGetAmountOfPizzas(){
        int expspected = 30;
        
        int actual = menu.getAmountOfPizzas();
        
        assertEquals(expspected, actual);
        
    }
    @Test
    public void testGetAmountOfToppings(){
        int exspected = 53;
        
        int acutal = menu.getAmountOfToppings();
        
        assertEquals(exspected, acutal);
    }
    @Test
    public void testGetPizza(){
        String exspected = "Quattro";
        
        String actual = menu.getPizza(3).getPizzaName();
        
        assertEquals(exspected, actual);
    }
}
