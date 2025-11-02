package problem3;

import java.util.Scanner;

// commenter les resultats

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Library library = new Library(0);
    public static void main (String[] args){
        System.out.println("How many documents in the library (more than 2): ");
        int n = scan.nextInt();

        library.setCapacity(n);

        Document doc1 = new Document("Doc1" );
        Document doc2 = new Book("Book1", "Unknown", 120) ;

        library.add(doc1) ;
        library.add(doc2) ;


        printMenu();
        int choice = scan.nextInt();
        while (choice != 0)
        {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }

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
                scan.nextLine();
                String title = scan.nextLine() ;

                System.out.println("Would you like to specify the type of document? (y or n) ");
                String rep = scan.nextLine();
                if (rep.equals("y")){
                    System.out.println("Please specify the type: (B(book), M(magazine) or D(dictionary)");
                    String type = scan.nextLine();
                    if (type.equals("M")){
                        System.out.println("month: ");
                        String month = scan.nextLine();
                        System.out.println("year: ");
                        int year = scan.nextInt();
                        Document newDoc = new Magazine(title, month, year) ;
                        library.add(newDoc);
                    }
                    if (type.equals("D")){
                        System.out.println("language: ");
                        String language = scan.nextLine();
                        Document newDoc = new Dictionary(title, language) ;
                        library.add(newDoc);
                    }
                    if (type.equals("B")){
                        System.out.println("author: ");
                        String author = scan.nextLine();
                        System.out.println("pages: ");
                        int nbrPages = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Would you like to specify the type of Book? ");
                        String rep1 = scan.nextLine();
                        if (rep1.equals("y")){
                            System.out.println("Please specify the type: (N or T)");
                            String type1 = scan.nextLine();
                            if (type1.equals("N")){
                                System.out.println("price: ");
                                double price = scan.nextDouble();
                                scan.nextLine();
                                Document newDoc = new Novel(title, author , nbrPages , price) ;
                                library.add(newDoc);
                            }
                            if (type1.equals("T")){
                                System.out.println("level: ");
                                String level = scan.nextLine();
                                Document newDoc = new TextBook(title, author , nbrPages , level) ;
                                library.add(newDoc);
                            }
                        }
                        else{
                            Document newDoc = new Book(title, author, nbrPages) ;
                            library.add(newDoc);
                        }
                    }
                }
                else {
                   Document newDoc = new Document(title) ;
                    library.add(newDoc);
                }
                break;
            case 2:  // display library
                System.out.println(library);
                break;
            case 3:  // delete document
                System.out.println("What document do you want to delete from library? (enter numReg) ");
                int numReg = scan.nextInt();
                Document doc = library.document(numReg);
                if (doc != null){
                    library.delete(doc) ;
                }
                break;
            case 4:
                System.out.println("What doc do you want to display? (enter numReg) ");
                numReg = scan.nextInt();
                System.out.println(library.document(numReg));
                break;
            case 5: // display authors
                library.displayAuthors();
                break;
            default:
                System.out.println("Sorry, invalid choice");
        }
    }
}
