
package model;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class IndividualStatistics {
    private int salesNumber = -1;
    private String pizzaName = null;
    private double price = -1;
    
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
}
