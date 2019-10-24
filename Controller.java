import java.io.Serializable;
import java.util.Scanner;

public class Controller {

    //Creating instance for Directory Class
    Directory directory = new Directory();
    Scanner scan = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("--------------------------");
            System.out.println("Enter the Option:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Show All Contacts");
            System.out.println("4. Edit a Contact");
            System.out.println("5. Remove a Contact");
            System.out.println("6. Exit");
            switch (scan.next()) {
                case "1": {
                    directory.add();
                    break;
                }
                case "2": {
                    directory.search();
                    break;
                }
                case "3": {
                    directory.showAll();
                    break;
                }
                case "4": {
                    directory.edit();
                    break;
                }
                case "5": {
                    directory.remove();
                    break;
                }
                case "6":
                    System.out.println("Exiting Windows..");
                    return;
                default:
                    System.out.println("Invalid input, Try Again");
                    System.out.println();
            }
        }
    }
}