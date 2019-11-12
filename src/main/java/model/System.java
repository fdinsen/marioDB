package model;
import datasource.DataSource;
import ui.UI;

public class System {
    
    private final DataSource datasource;
    private final UI ui;
    
    public System(DataSource datasource, UI ui){
        this.datasource = datasource;
        this.ui = ui;
    }
    
    public void startProgram() {
        ui.startUI();
        
    }
    
    public boolean checkIfCustomerExists(){
        
        
        return false;
    }
    public Customer createCustomer(int phoneNo, String name){
        
        
        return null;
    }
    public Customer getCustomer(int phone){
        
        
        return null;
    }
}
