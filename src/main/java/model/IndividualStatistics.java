
package model;

import java.time.LocalDateTime;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class IndividualStatistics {
    private int salesNumber = -1;
    private String pizzaName = null;
    private double price = -1;
    private LocalDateTime orderDate = null;
    private String toppings = null;
    
    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public IndividualStatistics(int amountOfSales) {
        this.salesNumber = amountOfSales;
    }
    public IndividualStatistics(double turnover) {
        price = turnover;
    }
    public IndividualStatistics(String pizzaName, int amountOfSales) {
        this.pizzaName = pizzaName;
        this.salesNumber = amountOfSales;
    }
    public IndividualStatistics(String pizzaName, String toppings, LocalDateTime orderDate, double price) {
        this.pizzaName = pizzaName;
        this.toppings = toppings;
        this.orderDate = orderDate;
        this.price = price;
    }
    
    //---------//
    // SETTERS //
    //---------//
    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setOrderDate(LocalDateTime dateTime) {
        this.orderDate = dateTime;
    }
    public void setToppings(String toppingsString) {
        this.toppings = toppingsString;
    }
    
    //---------//
    // GETTERS //
    //---------//
    public int getSalesNumber() {
        return salesNumber;
    }
    public String getPizzaName() {
        return pizzaName;
    }
    public double getPrice() {
        return price;
    }
    public LocalDateTime getOrderTime() {
        return orderDate;
    }
    public String getToppingsString() {
        return toppings;
    }
}
