import ua.sputilovsoftware.Main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    private Main main;
    private InputStream inputStream;
    private Reader readerIS;
    private Properties rusProperty;
    private Properties engProperty;
    private String [] args;
    public MainTest() {
    }

    /**
     * Initialization the needs variables for test
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        main = new Main();
        engProperty = new Properties();
        rusProperty = new Properties();
        args = new String [0];

        // load eng property
        inputStream = getClass().getClassLoader().getResourceAsStream("greeting_eng.properties");
        readerIS = new InputStreamReader(inputStream, "UTF-8");
        engProperty.load(readerIS);

        // load rus property
        inputStream = getClass().getClassLoader().getResourceAsStream("greeting_rus.properties");
        readerIS = new InputStreamReader(inputStream, "UTF-8");
        rusProperty.load(readerIS);

    }

    /**
     * Test of the getProperty method of the class Main.
     *
     * @throws IOException
     */
    @Test
    public void testGetEngPropertyWhenNoArgument() throws IOException {

        // The method have to return "greeting_eng.properties" when gets nothing as the method's parameter.
        assertEquals(engProperty, main.getProperty(args));
    }

    @Test
    public void testGetRusPropertyWhenArgumentIsRus() throws IOException {

        // if will be some program argument
        args = new String[1];

        // The method have to return "greeting_rus.properties" when gets string "rus" as the method's parameter.
        args[0] = "rus";
        assertEquals(rusProperty, main.getProperty(args));
    }

    @Test
    public void testGetEngPropertyWhenArgumentIsAnyString() throws IOException {

        // if will be some program argument
        args = new String[1];

        // The method have to return "greeting_eng.properties" when gets any string as the method's parameter.
        args[0] = "asdf"; // any other string
        assertEquals(engProperty, main.getProperty(args));
    }
}
