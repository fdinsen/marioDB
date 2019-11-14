/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    public IndividualStatistics getTotalSales() {
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
}
