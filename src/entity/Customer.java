package entity;

/**
 * The {@code Customer} class represents a customer in a car rental system. It
 * encapsulates information about a customer, including their identification,
 * first name, last name, email, and phone number.
 */
public class Customer {

	/**
	 * The unique identifier for the customer.
	 */
	private int customerID;

	/**
	 * The first name of the customer.
	 */
	private String firstName;

	/**
	 * The last name of the customer.
	 */
	private String lastName;

	/**
	 * The email address of the customer.
	 */
	private String email;

	/**
	 * The phone number of the customer.
	 */
	private String phone_num;

	/**
	 * Constructs a new Customer object with the specified parameters.
	 *
	 * @param customerID  The unique identifier for the customer.
	 * @param firstName   The first name of the customer.
	 * @param lastName    The last name of the customer.
	 * @param email       The email address of the customer.
	 * @param phoneNumber The phone number of the customer.
	 */
	public Customer(int customerID, String firstName, String lastName, String email, String phone_num) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone_num = phone_num;
	}

	/**
	 * Retrieves the unique identifier for the customer.
	 *
	 * @return The customer ID.
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * Sets the unique identifier for the customer.
	 *
	 * @param customerID The customer ID to set.
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * Retrieves the first name of the customer.
	 *
	 * @return The first name of the customer.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the customer.
	 *
	 * @param firstName The first name to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of the customer.
	 *
	 * @return The last name of the customer.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the customer.
	 *
	 * @param lastName The last name to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retrieves the email address of the customer.
	 *
	 * @return The email address of the customer.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the customer.
	 *
	 * @param email The email address to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the phone number of the customer.
	 *
	 * @return The phone number of the customer.
	 */
	public String getPhoneNumber() {
		return phone_num;
	}

	/**
	 * Sets the phone number of the customer.
	 *
	 * @param phoneNumber The phone number to set.
	 */
	public void setPhoneNumber(String phone_num) {
		this.phone_num = phone_num;
	}

	/**
	 * Returns a string representation of the Customer object.
	 *
	 * @return A string representation of the Customer object.
	 */
	@Override
	public String toString() {
		return "Customer{" + "customerID=" + customerID + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + ", email='" + email + '\'' + ", phoneNumber='" + phone_num + '\'' + '}';
	}
}
