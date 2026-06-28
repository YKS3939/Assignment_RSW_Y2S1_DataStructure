package tarc.assignment.util;
import java.io.InputStream;
import java.util.Properties;

/*
    Similar Node.Js,php dotenv
    how to use:get global environment with here
*/
public class Environment {
    private static final String FILE="config.properties";
    private static final Properties PROPERTIES = new Properties();

    static{
        try (InputStream input =Environment.class.getClassLoader().getResourceAsStream(FILE)) {
            if (input == null) {
                throw new RuntimeException(FILE + " not found");
            }
            PROPERTIES.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param {string} key - the env name
     * @return {string} a value
     */
    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    /**
     * @param {string} key - the env name
     * @param {String} defaultValue - your default value if there doesn't exist
     * @return {string} a value or default
     */
    public static String get(String key,String defaultValue) {
        return PROPERTIES.getProperty(key,defaultValue);
    }
}
