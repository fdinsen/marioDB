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
 * @author simon
 */
public class SavedOrdersMapperTest {
    
    public SavedOrdersMapperTest() {
    }

    /**
     * Test of insertOrder method, of class SavedOrdersMapper.
     */
    @Test
    public void testInsertOrder() {
        System.out.println("insertOrder");
        Customer cust = new Customer(12345678);
        Order ord = new Order(cust);
        SavedOrdersMapper instance = new SavedOrdersMapper();
        instance.insertOrder(ord);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
