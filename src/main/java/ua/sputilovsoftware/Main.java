package ua.sputilovsoftware;

import ua.sputilovsoftware.entities.Greeting;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import org.apache.log4j.Logger;


/**
 * The main class.
 *
 * The Main method can get the argument, for select the language.
 * If entered "rus" in any case (lower, upper), the greeting will in russian,
 * if entered nothing or entered any other arguments
 * the app chooses the english default language of greeting.
 *
 */
public class Main {

    private final static String ENGLISH = "eng";
    private final static String RUSSIAN = "rus";
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    private static Properties property = new Properties();


    /**
     *
     * @param args - app arguments
     */
    public static void main(String[] args) {

        LOG.info("The app started");
        LOG.debug("The arguments is :" + Arrays.toString(args));
        Greeting greeting = new Greeting(new Main().getProperty(args));
        greeting.printGreeting();
        LOG.info("The app finished successfully!");
    }

    /**
     * The method return properties, depending of "main method"  argument.
     *
     * @param args - program argument
     * @return - property in the need language
     */
    public Properties getProperty(String [] args) {

        // if isn't arguments  use greeting_eng.properties
        if (args.length == 0) {
            LOG.info("The arguments are not entered, the default language is english");
            setProperty(ENGLISH);
            return property;
        // if argument is "rus" use greeting_rus.properties
        } else if (args[0].toLowerCase().equals(RUSSIAN)) {
            LOG.info("The argument is \"rus\", selected the russian language of greeting messages");
            setProperty(RUSSIAN);
            return property;
        }
        // default use greeting_rus.properties
        LOG.info("The arguments are unknown, the default language is english");
        setProperty(ENGLISH);
        return property;
    }

    /**
     * The method chooses and loads needs properties to variable (property), depending of parameters
     *
     * @param language - "eng" or "rus"
     */
    private void setProperty (String language) {

        InputStream inputStream;
        Reader readerIS;
        try {
            if (language.equals(RUSSIAN)) {
                // load property file in russian
                inputStream = getClass().getClassLoader().getResourceAsStream("greeting_" + RUSSIAN + ".properties");
                readerIS = new InputStreamReader(inputStream, "UTF-8");
                property.load(readerIS);
                LOG.debug("Selected russian language");
            } else  if (language.equals(ENGLISH)) {
                // load property file in english
                inputStream = getClass().getClassLoader().getResourceAsStream("greeting_" + ENGLISH + ".properties");
                readerIS = new InputStreamReader(inputStream, "UTF-8");
                property.load(readerIS);
                LOG.debug("Selected english language");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOG.error(e, e);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error(e, e);
        }
    }
}
