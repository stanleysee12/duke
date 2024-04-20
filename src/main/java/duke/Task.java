package duke;

public class Task {
    protected String description;
    protected boolean isDone;
    protected int priority ;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.priority = 0 ;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getPriority(){
        return priority;
    }
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public void markAsNotDone(){
        this.isDone = false;
    }

    public String getDescription (){
        return description;
    }
    @Override
    public String toString(){
        return "[" + getStatusIcon() + "]" + " " + getDescription() + " P: " + getPriority();
    }
    //...
}
