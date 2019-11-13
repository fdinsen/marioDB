package model;

import java.util.ArrayList;
import datasource.DataSource;
import model.Customer;

public class OrderList {
    
    private ArrayList<Order> activeOrders = new ArrayList<>();
    private final DataSource datasource;
    
    public OrderList(DataSource datasource){
        this.datasource = datasource;
        
    }
    public void completeOrder(int index){

        
    }
    //TODO Creates order returnes orderlistIndex
    public int createOrder(Customer customer){
        activeOrders.add((new Order(customer)));
        return activeOrders.size()-1;
    }
    public void deleteOrder(int orderNo,int orderLineID){
        
        
    }
    public void finishOrder(int orderListIndex){
        
        
    }

    public Order getOrder(int orderListIndex){
        return activeOrders.get(orderListIndex);

    }
    
    public int getOrdersListSize(){
        return activeOrders.size();
    }
    
    public ArrayList<Order> getActiveOrders(){
        return activeOrders;
    }
    
    public ArrayList<Pizza> getAllPizzasInOrder(int index){
       return  activeOrders.get(index-1).
    }

}
