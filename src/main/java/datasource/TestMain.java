/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import model.Customer;

/**
 *
 * @author simon
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Customer cust = null;
        CustomerMapper mapper = new CustomerMapper();
//        if(mapper.customerExists(12345678)){
//            cust = mapper.getCustomer(90999897);
//        }
//        System.out.println(cust);
        
        Customer cust = mapper.createCustomer(33445566, "simon");
        if(mapper.customerExists(33445566)){
            System.out.println(mapper.getCustomer(33445566));
        }
    }
    
}