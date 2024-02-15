import java.util.ArrayList;
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
        String taskNo = null;
        //String[] arrayInput = new String[100];
        Task[ ] arrayInput = new Task[100];


        int arrayIndex = 0 ;

        Scanner scGreeting = new Scanner(System.in);

        System.out.println("Hello from\n" + logo);
        System.out.println(greeting);




        while(true)
        {
            userInput = scGreeting.nextLine();
            //checks for unmark and mark first
            if(userInput.length() > 2)
            {
                String[] temp = userInput.split(" ");
                if((temp[0].equalsIgnoreCase("mark") || temp[0].equalsIgnoreCase("unmark")))
                {
                    userInput = temp[0];
                    taskNo = temp[1];
                }
            }

            if(userInput.equalsIgnoreCase("bye"))
            {
                System.out.println(ending);
                System.exit(0);
            }
            else if(userInput.equalsIgnoreCase("list"))
            {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < arrayInput.length; i++) {
                    if (arrayInput[i] == null)
                    {
                        break;
                    }

                    System.out.printf("%d. [%s] %s%n", i + 1, arrayInput[i].getStatusIcon(),
                            arrayInput[i].description);

                }
            }
            else if((userInput.equalsIgnoreCase("mark")) || userInput.equalsIgnoreCase(("unmark")))
            {
                int number = Integer.parseInt(taskNo);
                if(userInput.equalsIgnoreCase("mark"))
                {
                    arrayInput[number -1].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                }
                else if(userInput.equalsIgnoreCase("unmark"))
                {
                    arrayInput[number -1].markAsNotDone();
                    System.out.println("OK, I've marked this task as not done yet:");
                }

                System.out.printf("[%s] %s%n", arrayInput[number-1].getStatusIcon(),
                        arrayInput[number-1].description);
            }
            //Example
            //Task t = new Task(userInput);
            //t.markAsDone();
            else {
                arrayInput[arrayIndex] = new Task(userInput);
                arrayIndex++;
                //arrayInput[arrayIndex] = userInput;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n" + "added: " + userInput);
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");
        }

    }
}
