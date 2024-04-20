package duke;

import java.util.ArrayList;
import java.util.List;
/**
 * The {@code TaskList} class represents a list of tasks and is able to edit the tasks
 * @tasks - all the list
 */
public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList(List<Task> loadTask) {
        this.tasks = new ArrayList<>(loadTask);
    }
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
    public void addTask (Task currentTask){
        tasks.add(currentTask);
    }

    public void removeTask(int index){
        if(index >= 0 && index < tasks.size()){
            tasks.remove(index);
        }
    }
    public void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
        }
    }

    public void markTaskAsNotDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsNotDone();
        }
    }

    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }
        return null; // Or throw an exception
    }
    public int size() {
        return tasks.size();
    }
}
