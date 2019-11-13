package model;

public class Customer {

    private String CustomerName;
    private int PhoneNo;
    
    public Customer(int phoneNo){
        //TODO check if customer exits, and get the name if its there
        //TODO If not it should create at new Customer
        this.PhoneNo = phoneNo;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public int getPhoneNo() {
        return PhoneNo;
    }
    @Override
    public String toString(){
        return ""+CustomerName+" : "+PhoneNo;
    }
}
