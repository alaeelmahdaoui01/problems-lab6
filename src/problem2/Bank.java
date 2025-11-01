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

    public boolean addCustomer(Customer customer){
        if (customers.contains(customer)){
            return false;
        }
        customers.add(customer) ;
        return true;
    }

    public boolean addTransaction(Customer customer, double transaction){  //autoboxing (double instead of Double)
        if (customers.contains(customer)){
            customer.getTransactions().add(transaction) ;
            return true;
        }
        return false;
    }

    public void printBank(){
        System.out.println("Bank data: ");
        for (Customer customer : customers){
            System.out.println("Customer: " + customer.getName());
            System.out.println("Transactions:  ");
            for (Double transaction : customer.getTransactions()){
                double a = transaction ;
                System.out.println("- " + a );
            }
            System.out.println("\n");
        }
    }
}
