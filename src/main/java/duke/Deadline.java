package duke;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * The {@code Deadline} class is able to add the correct format
 * @by - Date
 * @days - Day of the week
 */
public class Deadline extends Task {

    //protected String by;
    protected LocalDate by;
    protected String days;

    public Deadline(String description, String by, boolean load) {
        super(description);
        this.by = null;
        this.days = null;
        try{
            //expected input format
            //System.out.println("trying date");
            DateTimeFormatter afterFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            this.by = LocalDate.parse(by,afterFormat);
        } catch (Exception e) {
            try {
                if(load)
                {
                    this.days = by;
                }
                else {
                    DayOfWeek realDay = DayOfWeek.valueOf(by.toUpperCase(Locale.ENGLISH));
                    //System.out.println(realDay);
                    this.days = realDay.name();
                }


            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public String toString() {
        //System.out.println("Printing deadline Override");
        if(by != null)
        {
            DateTimeFormatter displayFormat = DateTimeFormatter.ofPattern("MMM d yyy");
            return "[D] " + super.toString() + " (by: " + this.by.format(displayFormat) + ")";
        }
        else
        {
            return "[D] " + super.toString() + " (by: " + this.days + ")";
        }

        //return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
