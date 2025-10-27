package problem2;

public class Main {
    public static void main (String[] args){
        Customer customer1 = new Customer("Alae");
        Bank bmce = new Bank("BMCE");
        bmce.addCustomer(customer1);
        bmce.addTransaction(customer1 , 200.0);
    }
}


// give the corresponding class diagram