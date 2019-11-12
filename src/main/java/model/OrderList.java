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
    public void celeteOrder(int index){
        
        
    }
    public void deleteOrder(int orderNo,int orderLineID){
        
        
    }
    public void finishOrder(int orderListIndex){
        
        
    }
}
