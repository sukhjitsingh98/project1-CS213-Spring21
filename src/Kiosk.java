import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

    public void run() {

        //Create the bag
        Library library = new Library();
        System.out.println("Running...");
        int increment = 0;

        Scanner sc = new Scanner(System.in);
        //continuously loop and scan until the session is ended by the input of "Q".
        while(sc.hasNext()){

            //stringTokenizer with a comma as a delimiter
            StringTokenizer input = new StringTokenizer(sc.nextLine(), ",");

            String statement1 = "";
            String statement2 = "";
            String statement3 = "";

            //assign the statements if possible
            if(input.hasMoreTokens()) {
                statement1 = input.nextToken();
            }
            if(input.hasMoreTokens()) {
                statement2 = input.nextToken();
            }

            if(input.hasMoreTokens()) {
                statement3 = input.nextToken();
            }

            //If the input is "Q", then break out of the loop to exit.
            if(statement1.equals("Q") && statement2.equals("") && statement3.equals("")) {
                break;
            }

            else if(statement1.equals("PA") && statement2.equals("") && statement3.equals("")){
                if(library.getNumBooks()==0){
                    System.out.println("Library catalog is empty!");
                }
                else {
                    System.out.println("**List of books in the library.");
                    library.print();
                    System.out.println("**End of list");
                }
            }
            else if(statement1.equals("PD") && statement2.equals("") && statement3.equals("")){
                if(library.getNumBooks()==0){
                    System.out.println("Bookshelf is empty!");
                }
                else {
                    System.out.println("**List of books by date published.");
                    library.printByDate();
                    System.out.println("**End of list");
                }
            }
            else if(statement1.equals("PN") && statement2.equals("") && statement3.equals("")){
                if(library.getNumBooks()==0){
                    System.out.println("Bookshelf is empty!");
                }
                else {
                    System.out.println("**List of books by the book numbers.");
                    library.printByNumber();
                    System.out.println("**End of list");
                }
            }
            else if(statement1.equals("A")){
                if(!statement2.equals("") && !statement3.equals("")){
                    if(new Date(statement3).isValid()){
                        int serialNumber = Constants.startingSerialNumber + increment;
                        Book book = new Book(Integer.toString(serialNumber), statement2, statement3);
                        library.add(book);
                        System.out.println(statement2 + " added to the library.");
                        increment++;
                    }
                    else{
                        System.out.println("Invalid Date!");
                        continue;
                    }
                }
                else{
                    System.out.println("Invalid Command!");
                    continue;
                }
            }
            else if(statement1.equals("R")){
                if(!statement2.equals("") && statement3.equals("")){
                    //create a new book with the serial number that was given, the name and date are not needed and can be anything.
                    Book removeBook = new Book(statement2, "someName", "someDate");
//                    if(library.remove(removeBook)) {
//                        System.out.println("Book removed.");
//                    }
//                    else{
//                        System.out.println("BOOK NOT REMOVED");
//                    }

                }
            }
            else if(statement1.equals("O")){
                if(!statement2.equals("") && statement3.equals("")){
                    //NOTE: This one is a bit confusing since the find() command is private and we need to pass the
                    // serial number as an argument
                    Book book = new Book(statement2, "random book", "2/1/2020");
                    Boolean checkOut = library.checkOut(book);
                    if(checkOut){
                        System.out.println("You've checked out Book#"+statement2+". Enjoy!");
                    }
                    else{
                        System.out.println("Book#"+statement2+" is not available.");
                    }
                }
                else{
                    System.out.println("Invalid Command!");
                    continue;
                }
            }
            else if(statement1.equals("I")) {
                if (!statement2.equals("") && statement3.equals("")) {
                    //NOTE: This one is a bit confusing since the find() command is private and we need to pass the
                    // serial number as an argument
                    Book book = new Book(statement2, "random book", "2/1/2020");
                    Boolean returns = library.returns(book);
                    if(returns){
                        System.out.println("Book#"+statement2+" return has completed. Thanks!");
                    }
                    else{
                        System.out.println("Book#"+statement2+" was not checked out!");
                    }
                }
                else{
                    System.out.println("Invalid Command!");
                    continue;
                }
            }
            else{
                System.out.println("Invalid Command!");
                continue;
            }



        }

        //Display final ending message.
        System.out.println("Kiosk session ended.");

    }

}
