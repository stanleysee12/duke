import java.util.ArrayList;
import java.util.List;

//TaskList: contains the task list e.g., it has operations to add/delete tasks in the list
public class TaskList {

    private List<Task> tasks;

    public TaskList(List<Task> loadTask) {
        this.tasks = new ArrayList<>();
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
}
