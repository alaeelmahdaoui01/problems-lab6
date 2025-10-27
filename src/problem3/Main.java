package problem3;

import java.util.Scanner;

// commenter les resultats

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main (String[] args){
        System.out.println("How many documents in the library: ");
        int n = scan.nextInt();

        Library library = new Library(n);

        Document doc1 = new Document("josipa" );
        Document doc2 = new Book("jsp2", "Alae", 120) ;

        library.add(doc1) ;
        library.add(doc2) ;




    }



    public static void printMenu()
    {
        System.out.println("\n Menu ");
        System.out.println(" ====");
        System.out.println("0: Quit");
        System.out.println("1: Add Document");
        System.out.println("2: Display library");
        System.out.println("3: Delete Document");
        System.out.println("4: Display Document with specific numRec");
        System.out.println("5: Display Authors");
        System.out.print("\nEnter your choice: ");
    }


    public static void dispatch(int choice)
    {
        switch(choice)
        {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println("Enter the title of document: ");
                String title = scan.next() ;

                System.out.println("Would you like to specify the type of document? (y or n) ");
                String rep = scan.next();
                if (rep.equals("y")){
                    System.out.println("Please specify the type: (B, M or D)");
                    String type = scan.next();
                    if (type.equals("M")){
                        System.out.println("month: ");
                        String month = scan.next();
                        System.out.println("year: ");
                        int year = scan.nextInt();
                        Document newDoc = new Magazine(title, month, year) ;
                    }
                    if (type.equals("D")){
                        System.out.println("language: ");
                        String language = scan.next();
                        Document newDoc = new Dictionary(title, language) ;
                    }
                    if (type.equals("B")){
                        System.out.println("author: ");
                        String author = scan.next();
                        System.out.println("pages: ");
                        int nbrPages = scan.nextInt();
                        System.out.println("Would you like to specify the type of Book? ");
                        String rep1 = scan.next();
                        if (rep1.equals("y")){
                            System.out.println("Please specify the type: (N or T)");
                            String type1 = scan.next();
                            if (type1.equals("N")){
                                System.out.println("price: ");
                                double price = scan.nextDouble();
                            }
                            if (type1.equals("T")){
                                System.out.println("level: ");
                                String level = scan.next();
                            }
                        }
                        else{
                            Document newDoc = new Book(title, author, nbrPages) ;
                        }
                    }
                }
                else {
                   Document newDoc = new Document(title) ;
                }


                break;
            case 2:
                list.print();
                break;
            case 3:

                System.out.println("What element do you want to add to the list? ");
                int element = scan.nextInt();
                list.addElement(element);
                break;
            case 4:

                System.out.println("What element do you want to remove from the list? ");
                int value1 = scan.nextInt();
                list.removeFirst(value1);
                break;
            case 5:

                System.out.println("What value do you want to remove from the list? ");
                int value2 = scan.nextInt();
                list.removeAll(value2);
                break;
            default:
                System.out.println("Sorry, invalid choice");
        }
    }
}
