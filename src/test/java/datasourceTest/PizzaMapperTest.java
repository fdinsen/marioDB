/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasourceTest;

import datasource.PizzaMapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olvvang
 */
public class PizzaMapperTest {
    
    public PizzaMapperTest() {
        
    }
    @Test
    public void getAllPizzasTest(){
        PizzaMapper pizzamap = new PizzaMapper();
        
        int expectedLength = 30;
        int actualLength = pizzamap.getAllPizzas().size();
        
        assertEquals(expectedLength, actualLength);
    }
    
    @Test
    public void getDefaultToppingsForPizzaSizeTest(){
        PizzaMapper pizzamap = new PizzaMapper();
        
        int expectedLength = 3;
        int actualLength = pizzamap.getDefaultToppingsForPizza(1).size();
        
        assertEquals(expectedLength, actualLength);
    }
    
    @Test
    public void getDefaultToppingsForPizzaExactPizzaToppingTest(){
        PizzaMapper pizzamap = new PizzaMapper();
        
        int expectedID = 26;
        int actualID= pizzamap.getDefaultToppingsForPizza(1).get(1);
        
        assertEquals(expectedID, actualID);
    }
    
    
}
