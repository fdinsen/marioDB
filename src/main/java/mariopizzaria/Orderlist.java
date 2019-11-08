package mariopizzaria;

import java.util.ArrayList;

/**
 *
 * @author <Oliver Vang>
 */
public class Orderlist {
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private ArrayList<Order> listOfOrders = new ArrayList<>();
    private Statistics statistics = Statistics.getInstance();

    //--------------//
    // CONSTRUCTERS //
    //--------------//
    private Orderlist() {
    }

    //------------//
    // SINGLETON  //
    //------------//
    public static Orderlist getInstance() {
        return OrderlistHolder.INSTANCE;
    }

    private static class OrderlistHolder {

        private static final Orderlist INSTANCE = new Orderlist();
    }

    //---------//
    // GETTERS //
    //---------//
    public Order getOrder(int index) {
        return listOfOrders.get(index - 1);
    }

    public int getPizzaCountInOrder(int orderNumberInArray) {
        return listOfOrders.get(orderNumberInArray - 1).getNumberOfPizzas();
    }

    public int getOrdersListSize() {
        return listOfOrders.size();
    }

    public ArrayList<Order> getActiveOrders() {
        return listOfOrders;
    }

    public String getOrderTimeMinutes(int index) {
        return getOrder(index).getOrderTimeMinute();
    }

    public String getPickUpTimeHour(int index) {
        return getOrder(index).getPickupTimeHour();
    }

    public String getPickUpTimeMinutes(int index) {
        return getOrder(index).getPickupTimeMinute();
    }

    public String getOrderTimeHour(int index) {
        return getOrder(index).getOrderTimeHour();
    }

    public String getCustomerName(int index) {
        return getOrder(index).getCostumerName();
    }

    public int getCustomerPhone(int index) {
        return getOrder(index).getCostumerPhoneNumber();
    }

    public ArrayList<Pizza> getAllPizzasInOrder(int index) {
        return getOrder(index).getAllPizzasInOrder();
    }

    public double getTotalPrice(int index) {
        return getOrder(index).getTotalPrice();
    }

    public int createOrder(boolean orderByPhone) {
        //Creates new order and returns the pos
        listOfOrders.add(new Order(orderByPhone));
        return listOfOrders.size();

    }

    //---------//
    // METHODS //
    //---------//
    public void completeOrder(int index) {
        //Updates statistics
        statistics.updateStats(listOfOrders.get(index - 1));
        //Removes the order from the list
        this.listOfOrders.remove(index - 1);
    }

    public void completeOrder(int index, boolean lostOrder) {
        //Updates statistics with lostOrder
        if (lostOrder) {
            System.out.println(listOfOrders.get(index));
            statistics.lostOrder(listOfOrders.get(index));
        } else {
            statistics.updateStats(listOfOrders.get(index));
        }

        //Removes the order from the list
        this.listOfOrders.remove(index);
    }

    public void deleteOrder(int index) {
        this.listOfOrders.remove(index - 1);
    }

    public void deletePizzaFromOrder(int orderNumberInArray, int pizzaNumberInOrder) {
        listOfOrders.get(orderNumberInArray - 1).removePizzaFromOrder(pizzaNumberInOrder - 1);
    }

    public Boolean isOrderedByPhone(int index) {
        return getOrder(index).isOrderedByPhone();
    }
    
    
    void clearOrderlist() {
        for (int i = 0; i < listOfOrders.size() ; i++) {
            listOfOrders.remove(i);
        }
    }

}
