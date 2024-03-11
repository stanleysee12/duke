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
            //splits into and descriptions when user input
            if(userInput.length() > 2)
            {
                String[] temp = userInput.split(" ",2);
                switch (temp[0].toLowerCase()){
                    case "mark":
                    case "unmark":
                    case "todo":
                    case "deadline":
                    case "event":
                        userInput = temp[0];
                        taskNo = temp[1];
                        break;
                    default:
                        break;
                }
            }
            ///ends here
            if(userInput.equals("bye"))
            {
                System.out.println(ending);
                System.exit(0);
            }
            else if(userInput.equals("list"))
            {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < arrayInput.length; i++) {
                    if (arrayInput[i] == null)
                    {
                        break;
                    }
                    System.out.printf("%d. %s%n", i + 1, arrayInput[i].toString());
                }
            }
            else if((userInput.equals("mark")) || userInput.equals(("unmark")))
            {
                int number = Integer.parseInt(taskNo);
                if(userInput.equals("mark"))
                {
                    arrayInput[number -1].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                }
                else if(userInput.equals("unmark"))
                {
                    arrayInput[number -1].markAsNotDone();
                    System.out.println("OK, I've marked this task as not done yet:");
                }
                System.out.println(arrayInput[number-1].toString());
            }
            else if (userInput.equals("todo"))
            {
                System.out.println("Got it. I've added this task: " );
                arrayInput[arrayIndex] = new ToDo (taskNo);
                System.out.println(arrayInput[arrayIndex]);
                arrayIndex++;
                System.out.println("Now you have " + arrayIndex + " tasks in the list");
            }
            else if (userInput.equals("deadline"))
            {
                String [] splitBy = taskNo.split(" /by " , 2);
                System.out.println("Got it. I've added this task: " );
                arrayInput[arrayIndex] = new Deadline(splitBy[0],splitBy[1]);
                System.out.println(arrayInput[arrayIndex]);
                arrayIndex++;
                System.out.println("Now you have " + arrayIndex + " tasks in the list");

            }
            else if(userInput.equals("event"))
            {
                String start;
                String end;
                System.out.println("Got it. I've added this task: " );
                //description of event split from date/time
                String [] splitEvent = taskNo.split(" /from " , 2);
                //checks if there is start&end date/time
                String [] splitStartEnd = splitEvent[1].split(" /to ", 2);
                if(splitStartEnd.length > 1){
                    start = splitStartEnd[0];
                    end = splitStartEnd[1];
                }
                else
                {
                    start = splitStartEnd[0];
                    end = " ";
                }
                arrayInput[arrayIndex] = new Event (splitEvent[0],start,end);
                System.out.println(arrayInput[arrayIndex]);
                arrayIndex++;
                System.out.println("Now you have " + arrayIndex + " tasks in the list");
            }
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

