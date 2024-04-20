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

    public ArrayList<Task> load() {
        //System.out.println("Loaded task");
        ArrayList<Task> loadTask = new ArrayList<>();
        File file = new File(path);
        String type = null;
        int status = 0 ;
        String [] splitType = null;
        String [] splitPri = null;
        String [] splitDes = null;
        int currentIndex = 0;
        int setPriority = 0;
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String currentLine = scanner.nextLine();
                    Task task = new Task(currentLine);
                    //System.out.println(currentLine);
                    //Assistance from https://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters
                    splitType = currentLine.split("(?<=] )", 3);
                    //System.out.println(splitType[0]);
                    //System.out.println(splitType[1]);
                    //System.out.println(splitType[2]);
                    splitPri = splitType[2].split(" ", 2);

                    //System.out.println(splitPri[1]);
                    if(splitPri[1].contains("1"))
                    {
                        System.out.println("setting priority");
                        setPriority = 1;
                    }
                    else{
                        setPriority = 0;
                    }



                    if(splitPri[1].contains("by"))
                    {
                        //System.out.println("i came");
                        splitDes = splitPri[1].split("(?=\\()", 2);
                        //System.out.println(splitDes[1]);
                    } else if (splitPri[1].contains("from")) {
                        //System.out.println("for event");
                        splitDes = splitPri[1].split("(from: )" , 2);
                        //System.out.println(splitDes[1]);
                    } else
                    {
                        //System.out.println(splitPri[1]);
                    }

                    //System.out.println(splitType[0]);

                    if(splitType[0].contains("E"))
                    {
                        String [] splitTime = splitDes[1].split("to: " , 2);

                        loadTask.add(new Event(splitDes[0].substring(splitDes[0].length() -1) , splitTime[0] , splitTime[1].substring(splitTime.length-1)));
                    }
                    else if(splitType[0].contains("D"))
                    {
                        String [] splitDeadline = splitDes[1].split("by: ", 2);
                        splitDeadline[1] = splitDeadline[1].substring(0,splitDeadline[1].length() -1);
                        //System.out.println(splitDeadline[1]);
                        loadTask.add(new Deadline(splitDes[0],splitDeadline[1],true));
                    }
                    else if(splitType[0].contains("T")){
                        loadTask.add(new ToDo(splitPri[1]));
                    }
                    else {
                        loadTask.add(task);
                    }

                    if(splitType[1].contains("X"))
                    {
                        loadTask.get(currentIndex).markAsDone();
                    }
                    else{
                        loadTask.get(currentIndex).markAsNotDone();
                    }

                    loadTask.get(currentIndex).setPriority(setPriority);
                    currentIndex++;

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }return loadTask;
    }
    public void save(ArrayList<Task> tasks){
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
