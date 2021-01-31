import java.util.Scanner;

public class Kiosk {

    public void run() {

        //Create the bag
        Library library = new Library();
        System.out.println("Running...");

        Scanner sc = new Scanner(System.in);
        //continuously loop and scan until the session is ended by the input of "Q".
        while(sc.hasNext()){
            String input = sc.nextLine();
            //If the input is "Q", then break out of the loop to exit.
            if(input.equals("Q")) {
                break;
            }



        }

        //Display final ending message.
        System.out.println("Kiosk session ended.");

    }

}
