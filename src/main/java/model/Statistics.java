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
    private final Controller controller;
    
    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public Statistics(Controller controller) {
        this.controller = controller;
    }
    
    //---------//
    // GETTERS //
    //---------//
    public IndividualStatistics getAmountOfOrders() {
        return controller.getAmountOfOrders;
    }
    
    public IndividualStatistics getTotalTurnover() {
        return controller.getTotalTurnover();
    }
    
    public IndividualStatistics getAverageOrderPrice() {
        return controller.getAverageOrderPrice();
    }
    
    public IndividualStatistics getTopSellingPizza() {
        return controller.getTopSellingPizza();
    }
    
    public IndividualStatistics getBottomSellingPizza() {
        return controller.getBottomSellingPizza();
    }

    public ArrayList<IndividualStatistics> getAllPizzaSales() {
        return controller.getAllPizzaSales();
    }

    public ArrayList<IndividualStatistics> getCustomerOrders(int phoneNumber) {
        return controller.getCustomerOrders(phoneNumber);
    }
    
}
