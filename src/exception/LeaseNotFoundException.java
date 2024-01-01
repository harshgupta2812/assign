package exception;

/**
 * Exception class indicating that a lease with the specified details was not found.
 */
public class LeaseNotFoundException extends Exception {

    /**
     * Constructs a new LeaseNotFoundException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public LeaseNotFoundException(String message) {
        super(message);
    }
    
    
}
