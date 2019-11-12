/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasourceTest;

import datasource.PizzaMapper;
import java.awt.Menu;
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
    private void getAllPizzas(){
        PizzaMapper pz = new PizzaMapper();
        pz.getAllPizzas();
        
        
    }
    
    
}
