import jdk.jshell.spi.ExecutionControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

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

    public static boolean mainCode(String userInput) throws DukeException {
        //splits into and descriptions when user input
        String[] temp = new String[0] ;
        String temp2 = " ";
        System.out.println(userInput.length());
        if (userInput.length() > 2) {
            temp = userInput.split(" ", 2);
            try {
                if (userInput.startsWith(" "))
                // checks for space starting and input must be at least 3
                {
                    throw new DukeException("Invalid input");
                }
            } catch (DukeException e) {
                System.err.println("Invalid input , No starting with space");
            }

        }
        else {
            temp[0] = userInput;
        }
        System.out.println(temp[0]);



        switch (temp[0].toLowerCase()) {
            case "mark":// need check if valid task no
                int index = Integer.parseInt(temp2);
                break;
            /*case "unmark": // need check if valid task no
                userInput = temp[0];
                taskNo = temp[1];
                break;
            case "todo":
                if (temp.length == 1) {
                    try {
                        throw new DukeException("Todo Description is empty.Please fix");
                    } catch (DukeException e) {
                        validInput = false;
                        System.err.println(e.getMessage());
                    }
                } else {
                    userInput = temp[0];
                    taskNo = temp[1];
                }
                break;
            case "deadline": // check for valid date
                // deadline return book /by Sunday syntax
                userInput = temp[0];
                taskNo = temp[1];
                break;
            case "event": // check for valid time/date
                // event project meeting /from Mon 2pm /to 4pm  syntax
                userInput = temp[0];
                if (temp.length > 1) {
                    taskNo = temp[1];
                } else {
                    try {
                        throw new DukeException("Event Description is empty.Please fix");
                    } catch (DukeException e) {
                        validInput = false;
                        System.err.println(e.getMessage());
                    }

                }

                break;
            case "list":
                break;
            case "delete": // need check if within list
                if (taskNo.isEmpty()) {
                    try {
                        throw new DukeException("Invalid Delete");
                    } catch (DukeException e) {
                        validInput = false;
                        System.err.println(e.getMessage());
                    }
                } else {
                    userInput = temp[0];
                    taskNo = temp[1];
                }

                break;
            case "bye":
                validInput = true;
                break;

             */
            default:
                try {
                    throw new DukeException("Not part of my commands.Please input a valid one");
                } catch (DukeException e) {
                    System.err.println(e.getMessage());
                }
                break;
        }
        return false;
    }
}

