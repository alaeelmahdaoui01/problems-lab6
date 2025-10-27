package problem2;

import problem1.Item;

import java.util.ArrayList;

public class Customer {
    private String name ;
    private ArrayList<Double> transactions ;

    public Customer(String name){
        this.name = name ;
        transactions = new ArrayList<>();
    }

    public String getName(){
        return this.name ;
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        StringBuilder customer =  new StringBuilder("Customer: " + name);
        customer.append("\nTransactions: ");
        for (double transaction : transactions){
            customer.append("\n- ").append(transaction);
        }
        return customer.toString() ;
    }
}
