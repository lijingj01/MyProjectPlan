package as.lijingj.com.myprojectplan.feature;

import java.util.Calendar;

public interface DateTimeInterpreter {
    String interpretDate(Calendar date);

    String interpretTime(int hour);

    String interpretWeek(int date);
}
