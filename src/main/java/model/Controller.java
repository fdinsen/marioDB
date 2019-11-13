package model;
import datasource.DataSource;
import ui.UI;

public class Controller {
    
    private final DataSource datasource;
    private final UI ui;
    private final Menu menu;
    private final OrderList orderlist;
    
    public Controller(DataSource datasource, UI ui){
        this.datasource = datasource;
        this.ui = ui;
        menu = new Menu(datasource);
        orderlist = new OrderList(datasource);
        startProgram();
    }
    
    public void startProgram() {
        ui.startUI(this,menu,orderlist);
    }
    
    public boolean checkIfCustomerExists(){
        
        
        return false;
    }
    public Customer createCustomer(int phoneNo){
        return datasource.createCustomer(phoneNo);
    }
    
    public Customer getCustomer(int phone){
        
        
        return null;
    }
}
