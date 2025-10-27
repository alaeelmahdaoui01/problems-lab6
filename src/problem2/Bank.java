package problem2;

import java.util.ArrayList;

public class Bank {
    private String name ;
    private ArrayList<Customer> customers ;

    public Bank(String name){
        this.name = name ;
        customers = new ArrayList<>();
    }

    public String getName(){
        return this.name ;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer){
        if (customers.contains(customer)){
            return  ;
        }
        customers.add(customer) ;
    }

    public void addTransaction(Customer customer, Double transaction){
        if (customers.contains(customer)){
            customer.getTransactions().add(transaction) ;
        }
    }

    public void printBank(){
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }
}
