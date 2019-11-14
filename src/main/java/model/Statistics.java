/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class Statistics {
    private final Controller contoller;
    
    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public Statistics(Controller controller) {
        this.contoller = controller;
    }
    
    //---------//
    // GETTERS //
    //---------//
    public IndividualStatistics getAmountOfOrders() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public IndividualStatistics getTotalTurnover() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public IndividualStatistics getAverageOrderPrice() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public IndividualStatistics getTopSellingPizza() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public IndividualStatistics getBottomSellingPizza() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<IndividualStatistics> getAllPizzaStatistics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<IndividualStatistics> getCustomerOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
