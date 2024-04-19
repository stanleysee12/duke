package duke;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Deadline extends Task {

    //protected String by;
    protected LocalDate by;

    public Deadline(String description, String by) {
        super(description);
        try{
            //expected input format
            DateTimeFormatter afterFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            this.by = LocalDate.parse(by,afterFormat);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Please use 'yyyy-MM-dd'.");
        }
    }

    @Override
    public String toString() {
        System.out.println("Printing deadline Override");
        DateTimeFormatter displayFormat = DateTimeFormatter.ofPattern("MMM d yyy");
        return "[D]" + super.toString() + " (by: " + this.by.format(displayFormat) + ")";
        //return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
