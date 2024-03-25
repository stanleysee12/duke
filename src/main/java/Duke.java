import jdk.jshell.spi.ExecutionControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;





public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath){

        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }

    public void run() {
        ui.welcome();
        ArrayList <Task> arrayInput = new ArrayList<Task>();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readInput();
                ui.showLine(); // show the divider line ("_______")
                //Command c = Parser.parse(fullCommand);
                //c.execute(tasks, ui, storage);
                //isExit = c.isExit();
                arrayInput.add(new Task(fullCommand));
                storage.save(arrayInput);
                isExit = true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        //Generated via https://patorjk.com/


        new Duke("./data/tasks.txt").run();

    }
        /*
        String ending = "Bye. Hope to see you again soon";
        String userInput;
        String taskNo = null;
        //String[] arrayInput = new String[100];
        //Task[ ] arrayInput = new Task[100];
        ArrayList <Task> arrayInput = new ArrayList<Task>();


        int arrayIndex = 0 ;
        boolean validWord = true;
        boolean validInput =true;

        Scanner scGreeting = new Scanner(System.in);







        {



            ///ends here
           /* while(validInput){
                validInput =false;
                System.out.println(userInput);
                if(userInput.equals("bye"))
                {
                    System.out.println(ending);
                    System.exit(0);
                }
                else if(userInput.equals("list"))
                {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < arrayInput.size(); i++) {
                        System.out.printf("%d. %s%n", i + 1, arrayInput.get(i).toString());
                    }
                }
                else if((userInput.equals("mark")) || userInput.equals(("unmark")))
                {
                    int number = Integer.parseInt(taskNo);
                    if(userInput.equals("mark"))
                    {
                        arrayInput.get(number -1).markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                    }
                    else if(userInput.equals("unmark"))
                    {
                        arrayInput.get(number -1).markAsNotDone();
                        System.out.println("OK, I've marked this task as not done yet:");
                    }
                    System.out.println(arrayInput.get(number -1).toString());
                }
                else if (userInput.equals("todo"))
                {
                    System.out.println("Got it. I've added this task: " );
                    arrayInput.add(new ToDo(taskNo));
                    System.out.println(arrayInput.getLast());
                    arrayIndex++;
                    System.out.println("Now you have " + arrayIndex + " tasks in the list");
                }
                else if (userInput.equals("deadline"))
                {
                    String [] splitBy = taskNo.split(" /by " , 2);
                    System.out.println("Got it. I've added this task: " );

                    arrayInput.add(new Deadline(splitBy[0],splitBy[1]));
                    System.out.println(arrayInput.getLast());
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
                    arrayInput.add(new Event(splitEvent[0],start,end));
                    System.out.println(arrayInput.getLast());
                    arrayIndex++;
                    System.out.println("Now you have " + arrayIndex + " tasks in the list");
                }
                else if(userInput.equals("delete"))
                {
                    int tempDeleteNo = Integer.parseInt(taskNo);
                    System.out.println("Noted. Task has been removed");
                    System.out.println(arrayInput.size());
                    System.out.println(arrayInput.get(tempDeleteNo - 1));
                    arrayInput.remove(tempDeleteNo - 1);
                    arrayIndex -= 1;
                }
                else if(!validWord)
                {
                    validInput =false;
                    System.out.println("Please input in the correct syntax");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");
                }
                else {
                    arrayInput.add(new Task(userInput));
                    arrayIndex++;
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n" + "added: " + userInput);
                }

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");
                }
            }


    }
}
}*/
    }

