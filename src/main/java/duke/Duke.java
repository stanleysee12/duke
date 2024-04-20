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

    public void run() {
        ui.welcome();
        ArrayList<Task> arrayInput = storage.load();
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


