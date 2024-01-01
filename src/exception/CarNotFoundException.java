package exception;

/**
 * Exception class indicating that a car with the specified details was not found.
 */
public class CarNotFoundException extends Exception {

    public CarNotFoundException(String message) {
        System.out.println("car not found");
    }
    public String toString() {
    	return "car with this id not found";
    }
}
