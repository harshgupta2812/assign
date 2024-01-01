package exception;

/**
 * Exception class indicating that a customer with the same details already exists.
 */
public class CarAlreadyExistsException extends Exception {

    /**
     * Constructs a new CustomerAlreadyExistsException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public CarAlreadyExistsException(String message) {
        super(message);
    }
}
