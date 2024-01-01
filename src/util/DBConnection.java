package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 */
public class DBConnection {
    // Singleton instance of the database connection
    private static Connection connection;

    // Private constructor to prevent instantiation
    private DBConnection() {
    }

    /**
     * Retrieves a singleton instance of the database connection.
     *
     * @return The database connection.
     * @throws RuntimeException If there is an error establishing the database connection.
     */
    public static Connection getConnection() {
        // Check if the connection is not already established
        if (connection == null) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
    			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root","Harsh@2812");


                // Get the connection using properties from DBPropertyUtil
//                connection = DriverManager.getConnection(
//                        DBPropertyUtil.getPropertyString("db.url"),
//                        DBPropertyUtil.getPropertyString("db.username"),
//                        DBPropertyUtil.getPropertyString("db.password")
//                );
            } catch (ClassNotFoundException | SQLException e) {
                // Print the stack trace for debugging purposes
                e.printStackTrace();
                
                // Throw a runtime exception with a descriptive error message
                throw new RuntimeException("Failed to establish a database connection.");
            }
        }
        return connection;
    }
}
