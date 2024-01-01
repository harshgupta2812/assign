package exception;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException(String message) {
        System.out.println("customer not found");
    }
    public String toString() {
    	return "customer with this id not found";
    }
}