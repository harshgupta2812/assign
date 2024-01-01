package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class for reading properties from the database configuration file.
 */
public class DBPropertyUtil {

    /**
     * Retrieves the value of a specified property from the database configuration file.
     *
     * @param propertyName The name of the property to retrieve.
     * @return The value of the specified property.
     * @throws RuntimeException If there is an error reading the database configuration file or if the property is not found.
     */
    public static String getPropertyString(String propertyName) {
        // Create a Properties object to store key-value pairs from the configuration file
        Properties properties = new Properties();

        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties")) {
            // Check if the configuration file is found
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find database.properties");
            }

            // Load properties from the configuration file
            properties.load(input);

            // Retrieve and return the value of the specified property
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            // Throw a runtime exception with a descriptive error message if an IO exception occurs
            throw new RuntimeException("Unable to find or read database.properties", e);
        }
    }
}
