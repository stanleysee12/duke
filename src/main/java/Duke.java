import java.util.Scanner;
import java.util.Arrays;


public class Duke {
    public static void main(String[] args) {
        //Generated via https://patorjk.com/
        String logo =  "_______          __     _____ __________        __\n" +
                "\\      \\   _____/  |_  /  _  \\______   \\ _____/  |_ \n" +
                "/   |   \\ /  _ \\   __\\/  /_\\  \\|    |  _//  _ \\   __\\ \n" +
                "/    |    (  <_> )  | /    |    \\   |   (  <_> )  |  \n" +
                "\\____|__  /\\____/|__| \\____|__  /______  /\\____/|__|  \n";

        String greeting = "Hello! I'm NotABot \n" +
                        "What can I do for you?";
        String ending = "Bye. Hope to see you again soon";
        String userInput;

        Scanner scGreeting = new Scanner(System.in);

        System.out.println("Hello from\n" + logo);
        System.out.println(greeting);


        while(true)
        {
            userInput = scGreeting.nextLine();
            if(userInput.equalsIgnoreCase("exit"))
            {
                System.exit(0);
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n" + userInput);
        }

    }
}
