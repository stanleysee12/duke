package duke;

import java.util.ArrayList;
/*
Main class duke

*/
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {

        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (Exception e) {
            System.out.println("no task in file");
            tasks = new TaskList(new ArrayList<>());
        }

    }

    public ArrayList<Task> copyTasks(TaskList taskList) {
        // This function assumes TaskList can iterate over its tasks or provide them one by one , to copy existing text inside old file to new arraylist
        ArrayList<Task> newTaskArray = new ArrayList<>();
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.getTask(i);
            if (task != null) {
                newTaskArray.add(task);
            }
        }
        return newTaskArray;
    }

    public void run() {
        ui.welcome();
        ArrayList<Task> arrayInput = copyTasks(tasks);
        int arrayIndex = 0;
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readInput();
                ui.showLine(); // show the divider line ("_______")
                String c = Parser.mainCode(fullCommand, arrayInput, arrayIndex);
                if (fullCommand.equals("bye")) {
                    isExit = true;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        //saves everything at the end
        storage.save(arrayInput);
    }

    public static void main(String[] args) {
        //Text file path
        new Duke("./data/tasks.txt").run();

    }

}


