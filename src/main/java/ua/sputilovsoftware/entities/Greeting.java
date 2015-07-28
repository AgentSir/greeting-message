package ua.sputilovsoftware.entities;

import org.apache.log4j.Logger;
import ua.sputilovsoftware.enums.TimesOfDay;

import java.util.GregorianCalendar;
import java.util.Properties;

public class Greeting {

    private Enum timesOfDay;
    private Properties greetingMessages;
    private static final Logger LOG = Logger.getLogger(Greeting.class.getName());

    /**
     *  Constructor need to get the parameter, it's Properties (greeting in russian or in english language)
     *
     * @param greetingMessages - property with <K,V> where KEY is the times of day, VALUE is the greeting for this times of day
     */
    public Greeting(Properties greetingMessages) {
        GregorianCalendar calendar = new GregorianCalendar();
        int hours = calendar.get(java.util.Calendar.HOUR_OF_DAY);   // Get currently system time (hour)
        this.timesOfDay = TimesOfDay.getDayTime(hours);
        this.greetingMessages = greetingMessages;
    }

    public void setGreetingMessages(Properties greetingMessages) {
        this.greetingMessages = greetingMessages;
    }

    //print to console greeting message
    public void printGreeting() {
        System.out.println(greetingMessages.getProperty(timesOfDay.toString()));
        LOG.debug("Greeting message is: " + greetingMessages.getProperty(timesOfDay.toString()));
    }
}
