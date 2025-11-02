package challenge;


import problem3.*;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ListIterator;

public class Main {

    static LinkedList<Place> places = new LinkedList<>();
    static ListIterator<Place> iterator ;

    public static void main(String[] args) {
        places.add(new Place("Sydney", 0));
        places.add(new Place("Adelaide", 1374));
        places.add(new Place("Alice Springs", 2771));
        places.add(new Place("Perth", 3923));
        places.add(new Place("Darwin", 3972));

        iterator = places.listIterator();


        Scanner scan = new Scanner(System.in);


        printMenu();
        String choice = scan.nextLine().toLowerCase();
        while (!choice.equals("q") && !choice.equals("quit")) {
            dispatch(choice);
            printMenu();
            choice = scan.nextLine().toLowerCase();
        }
    }



    public static void printMenu()
    {
        System.out.println("Available actions: (select word or letter) ");
        System.out.println(" ====");
        System.out.println("(F)orward");
        System.out.println("(B)ackward");
        System.out.println("(L)ist places");
        System.out.println("(M)enu");
        System.out.println("(Q)uit");
        System.out.print("Enter your choice: ");
    }


    public static void dispatch(String choice)
    {
        switch(choice)
        {
            case "f":
            case "forward":
                if (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                else {
                    System.out.println("Reached the end of the list");
                }
                break;

            case "b":
            case "backward":
                if (iterator.hasPrevious()) {
                    System.out.println(iterator.previous());
                }
                else {
                    System.out.println("Reached the start of the list");
                }
                break;

            case "l":
            case "list":
                System.out.println("List of places from closest to farthest from source:");
                for (Place place : places) {
                    System.out.println(" - " + place);
                }
                break;

            case "m":
            case "menu":
                printMenu();
                break;

            case "q":
            case "quit":
                System.out.println("Bye!");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}
