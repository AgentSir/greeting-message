package ua.sputilovsoftware.enums;

import org.apache.log4j.Logger;

/**
 * The enumeration different times of day.
 */
public enum TimesOfDay {

    MORNING, DAY, EVENING, NIGHT;

    private static final Logger LOG = Logger.getLogger(TimesOfDay.class.getName());

    /**
     * The method defines the correct times of day depending on the time.
     *
     * @param hours - the current time's hours
     * @return - the times of day value of enum (TimesOfDay)
     */
    public static TimesOfDay getDayTime(int hours) {
            if(isBetween(hours, 6, 9)) {
                LOG.debug("returned \"MORNING\" enum");
                return MORNING;
            } else if(isBetween(hours, 9, 19)) {
                LOG.debug("returned \"DAY\" enum");
                return DAY;
            } else if(isBetween(hours, 19, 23)) {
                LOG.debug("returned \"EVENING\" enum");
                return EVENING;
            } else if(hours == 23) {
                LOG.debug("returned \"NIGHT\" enum");
                return NIGHT;
            } else if(isBetween(hours, 0, 6)) {
                LOG.debug("returned \"NIGHT\" enum");
                return NIGHT;
            }
        // Hours is in not valid range ( < 0 or > 23)
        return null;
    }

    /**
     * Checking the time. The method returns true if time is between the start and the top of the range.
     *
     * @param hours - current time in the hours.
     * @param start - hour in the start of the range
     * @param top - hour in the top of the range
     * @return - boolean type (true - if hours inside range, else - false)
     */
    private static boolean isBetween(int hours, int start, int top) {
        //return false if method got the incorrect parameter (hours)
        if (hours < 0 || hours > 23) {
            return false;
        //return true if hours inside the range (when start of the range less then top of the range)
        } else if(hours >= start && hours < top) {
            return true;
        }
        return false;
    }
}
