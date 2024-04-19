package duke;

import java.util.ArrayList;

//Parser: deals with making sense of the user command
public class Parser {
    private TaskList task;
    private Ui ui;
    private Storage storage;

    public Parser (TaskList task , Ui ui , Storage storage){
        this.task = task;
        this.ui = ui;
        this.storage = storage;
    }

    public static String mainCode(String userInput , ArrayList <Task> arrayInput , int arrayIndex) throws DukeException, RuntimeException {
        //splits into and descriptions when user input
        String[] temp = new String[0] ;
        String temp2 = " ";
        String taskNo = null ;
        System.out.println(userInput.length());
        boolean validInput = true;
        if (userInput.length() > 1) {
            temp = userInput.split(" ", 2);
            try {
                if (userInput.startsWith(" "))
                // checks for space starting and input must be at least 3
                {
                    validInput = false;
                    throw new DukeException("Invalid input");
                }
            } catch (DukeException e) {
                System.err.println("Invalid input , No starting with space");
            }
            userInput = temp[0];
            taskNo = temp.length > 1 ? temp[1] : null;

        }
        System.out.println(taskNo);
        //System.out.println(temp[0]);
        //System.out.println("Parse done");



        switch (temp[0].toLowerCase()) {
            case "mark":// need check if valid task no
            case "unmark": // need check if valid task no
                System.out.println("reached");
                int number = Integer.parseInt(taskNo) - 1;
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
                break;
            case "todo":
                if(taskNo == null) throw new DukeException("Todo description is empty");
                System.out.println("Got it. I've added this task: " );
                arrayInput.add(new ToDo(taskNo));
                System.out.println(arrayInput.getLast());
                System.out.println("Now you have " + arrayInput.size() + " tasks in the list");
                break;
            case "deadline": // check for valid date
                // deadline return book /by Sunday syntax
                if(taskNo == null) throw new DukeException("deadline description is empty");
                String [] splitBy = taskNo.split(" /by " , 2);
                if(splitBy.length < 2) throw new DukeException("Missing details");
                System.out.println("Got it. I've added this task: " );
                //System.out.println(splitBy[0]);
                //System.out.println(splitBy[1]);
                arrayInput.add(new Deadline(splitBy[0],splitBy[1]));
                System.out.println(arrayInput.getLast());
                System.out.println("Now you have " + arrayInput.size() + " tasks in the list");
                break;
            case "event": // check for valid time/date
                if(taskNo == null) throw new DukeException("event description empty");
                String start;
                String end;
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
                System.out.println("Got it. I've added this task: " );
                System.out.println(arrayInput.getLast());
                System.out.println("Now you have " + arrayInput.size() + " tasks in the list");

                break;
            case "list":
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < arrayInput.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, arrayInput.get(i).toString());
                }
                break;
            case "delete": // need check if within list ;
                int checkSize = Integer.parseInt(taskNo);
                //System.out.println(checkSize);
                //System.out.println(arrayInput.size());
                try{
                    if(checkSize < 0 || checkSize >= arrayInput.size())
                    {
                        throw new DukeException("Invalid Deletion");
                    }
                    int tempDeleteNo = Integer.parseInt(taskNo) - 1;
                    System.out.println("Noted. Task has been removed");
                    System.out.println(arrayInput.size());
                    System.out.println(arrayInput.get(tempDeleteNo));
                    arrayInput.remove(tempDeleteNo);
                } catch (DukeException e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "bye":
                String ending = "Bye. Hope to see you again soon";
                System.out.println(ending);
                break;
            case "priority" :
                //only 1 and 0
                //format priority priroitylevel/taskno
                System.out.println("Setting Priority");
                if(taskNo == null) throw new DukeException("invalid priority input");
                String split[] = taskNo.split("/" , 2);
                int priority = Integer.parseInt(split[0]);
                int num = Integer.parseInt(split[1]) - 1 ;
                arrayInput.get(num).setPriority(priority);
                System.out.println(arrayInput.get(num).toString());
                break;
            default:
                try {
                    throw new DukeException("Not part of my commands.Please input a valid one");
                } catch (DukeException e) {
                    System.err.println(e.getMessage());
                }
                break;
        }

       /* else {
            //arrayInput.add(new Task(userInput));
            arrayIndex++;
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n" + "added: " + userInput);
        } */

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");
        return temp[0];
    }

}



