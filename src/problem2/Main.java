package problem2;

public class Main {
    public static void main (String[] args){
        Customer customer1 = new Customer("Alae");
        Customer customer2 = new Customer("Hiba");
        Bank bmce = new Bank("BMCE");

        bmce.addCustomer(customer1);
        bmce.addCustomer(customer2);

        bmce.addTransaction(customer1 , 200);
        bmce.addTransaction(customer1 , -50.0);
        bmce.addTransaction(customer2 , -100.90);
        bmce.addTransaction(customer2 , 100.0);
    }
}


