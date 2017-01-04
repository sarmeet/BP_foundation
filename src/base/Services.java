package base;

import org.mongodb.morphia.Datastore;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by sarmeetsingh on 7/31/16.
 */

@WebListener()
public class Services implements ServletContextListener {

    public static final boolean DEBUG = true; // Application information to console
    public static DatabaseAccess db; // database access
    public static Datastore ds; // datastore access. ( Morphia specific implementation )

    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // Date Management


    // Public constructor is required by servlet spec
    public Services() {
    }

    public static String[] getweekStart(int week) {
        final ZonedDateTime startOfLastWeek = ZonedDateTime.now().minusWeeks(week).with(DayOfWeek.MONDAY);
        String[] dates = new String[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final ZonedDateTime endOfLastWeek = startOfLastWeek.plusDays(6);
        dates[0] = startOfLastWeek.format(formatter);
        dates[1] = endOfLastWeek.format(formatter);
        return dates;
    }

    public static Date[] getWeekStartInDate(int week) {
        String[] dateString = getweekStart(week);
        Date[] dateDate = new Date[2];
        dateDate[0] = StringToDate(dateString[0]);
        dateDate[1] = StringToDate(dateString[1]);
        return dateDate;
    }

    public static String getDisplayFormat(Date date) {
        return df.format(date);
    }


    /**
     * Change all String to dates.
     *
     * @param date String containing a date
     * @return Date extracted from String .
     */
    public static Date StringToDate(String date) {

        Date dateToReturn;
        try {
            dateToReturn = df.parse(date);
            return dateToReturn;
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date StringToDateYMD(String date) {

        Date dateToReturn;
        try {
            dateToReturn = df.parse(date);
            return dateToReturn;
        } catch (ParseException e) {
            return null;
        }

    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        db = new DatabaseAccess();
        ds = db.getDatastore();
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
    }


}
    

