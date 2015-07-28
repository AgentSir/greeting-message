import ua.sputilovsoftware.enums.TimesOfDay;

import static org.junit.Assert.*;
import org.junit.Test;

public class TimesOfDayTest {

    private Enum timesOfDay;

    /**
     * The test of the getDayTime method of the TimesOfDay enum
     * Checking the correct greeting in the all times of day
     *
     * @throws Exception
     */
    @Test
    public void testMorning() throws Exception {

        // Test to define a morning when time is 6, 7, 8 o'clock
        for (int i = 6; i <= 8; i++) {
            timesOfDay = TimesOfDay.getDayTime(i);
            assertEquals(TimesOfDay.MORNING, timesOfDay);
        }
    }

    @Test
    public void testDay() throws Exception {

        // Test to define a day when time is 9, 10 ,11, 12, 13, 14, 15, 16, 17, 18 o'clock
        for (int i = 9; i <= 18; i++) {
            timesOfDay = TimesOfDay.getDayTime(i);
            assertEquals(TimesOfDay.DAY, timesOfDay);
        }
    }

    @Test
    public void testEvening() throws Exception {

        // Test to define a evening when time is 19, 20, 21, 22 o'clock
        for (int i = 19; i <= 22; i++) {
            timesOfDay = TimesOfDay.getDayTime(i);
            assertEquals(TimesOfDay.EVENING, timesOfDay);
        }
    }

    @Test
    public void testNight() throws Exception {

        // Test to define a night when time is 23 o'clock
        timesOfDay = TimesOfDay.getDayTime(23);
        assertEquals(TimesOfDay.NIGHT, timesOfDay);

        // Test to define a night when time is 0, 1, 2, 3, 4, 5, 6 o'clock
        for (int i = 0; i <= 5; i++) {
            timesOfDay = TimesOfDay.getDayTime(i);
            assertEquals(TimesOfDay.NIGHT, timesOfDay);
        }
    }
}