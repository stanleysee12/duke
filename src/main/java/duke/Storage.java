package duke;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Storage: deals with loading tasks from the file and saving tasks in the file
public class Storage {
    private String path;

    public Storage(String path1)
    {
        this.path = path1;
    }
   /* public List<String> load(){
        List<String> test = new ArrayList<>();
        try {
            test = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return test;
    }*/
    public List<Task> load() {
        //System.out.println("Loaded task");
        List<Task> loadTask = new ArrayList<>();
        File file = new File(path);

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String currentLine = scanner.nextLine();
                    Task task = new Task(currentLine);
                    loadTask.add(task);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }return loadTask;
    }
    public void save(List<Task> tasks){
        File file = new File(path);
        File parentPath = file.getParentFile();
        if(!parentPath.exists()){
            parentPath.mkdirs();
        }
       try(FileWriter writeTo = new FileWriter(file,false) ){
           for(Task task : tasks){
               writeTo.write(task.toString() + System.lineSeparator());
           }
       } catch (IOException e) {
           throw new RuntimeException("Failed to save task" + e.getMessage(),e);
       }
    }

}
