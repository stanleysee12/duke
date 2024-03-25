import java.util.Scanner;


//Ui: deals with interactions with the user
public class Ui {

    public void welcome(){
        String logo =  "_______          __     _____ __________        __\n" +
                "\\      \\   _____/  |_  /  _  \\______   \\ _____/  |_ \n" +
                "/   |   \\ /  _ \\   __\\/  /_\\  \\|    |  _//  _ \\   __\\ \n" +
                "/    |    (  <_> )  | /    |    \\   |   (  <_> )  |  \n" +
                "\\____|__  /\\____/|__| \\____|__  /______  /\\____/|__|  \n";

        String greeting = "Hello! I'm NotABot \n" +
                "What can I do for you?";
        System.out.println("Hello from\n" + logo);
        System.out.println(greeting);
    }

    public String readInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showLine(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
    public void showLoadingError(){
        System.out.println("No file found");
    }
}
