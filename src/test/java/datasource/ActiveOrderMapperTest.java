/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import model.Customer;
import model.Order;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class ActiveOrderMapperTest {
    
    ActiveOrderMapper aomapper = new ActiveOrderMapper();
    
    public ActiveOrderMapperTest() {
    }

    /**
     * Test of getActiveOrders method, of class ActiveOrderMapper.
     */
    @Test
    public void testGetActiveOrders() {
        int actualNumberOfOrders;
        int expectedNumberOfOrders = 1;
        
        
        //actualNumberOfOrders = aomapper.getActiveOrders();
        
        //assertEquals(expectedNumberOfOrders, actualNumberOfOrders);
        
    }

    /**
     * Test of insertOrder method, of class ActiveOrderMapper.
     */
    @Test
    public void testInsertOrder() {
        Order order = new Order(new Customer(12345678));
        
        aomapper.insertOrder(order);
        
        
        
    }

    /**
     * Test of removeOrder method, of class ActiveOrderMapper.
     */
    @Test
    public void testRemoveOrder() {
    }
    
}
