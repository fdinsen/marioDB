package model;

import java.util.ArrayList;
import datasource.DataSource;

public class OrderList {
    
    private ArrayList<Order> activeOrders = new ArrayList<>();
    private final DataSource datasource;
    
    public OrderList(DataSource datasource){
        this.datasource = datasource;
        
    }
    public void completeOrder(int index){

        
    }
    //TODO Creates order returnes orderlistIndex
    public int createOrder(int phoneNumber){
        activeOrders.add(new Order(phoneNumber));
        return activeOrders.size()-1;
    }
    public void deleteOrder(int orderNo,int orderLineID){
        
        
    }
    public void finishOrder(int orderListIndex){
        
        
    }

    public Order getOrder(int orderListIndex){
        return activeOrders.get(orderListIndex);

    }

}
