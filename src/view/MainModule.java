package view;

import controller.CarRentalController;
import entity.Customer;
import entity.Car;
import entity.Lease;
import entity.Payment;
import exception.CarNotFoundException;
import exception.CarAlreadyExistsException;
import exception.CustomerAlreadyExistsException;
import exception.CustomerNotFoundException;
import exception.LeaseNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * The main class representing the entry point of the Car Rental Application.
 * It provides a command-line interface for managing customers, cars, leases, and payments.
 */
public class MainModule {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CarRentalController carRentalController = new CarRentalController();

    /**
     * The main method that displays the main menu and handles user input for various application features.
     *
     * @param args The command-line arguments (unused).
     * @throws CarNotFoundException             If a car is not found during processing.
     * @throws CustomerAlreadyExistsException   If a customer already exists during customer addition.
     * @throws CustomerNotFoundException        If a customer is not found during customer-related operations.
     * @throws CarAlreadyExistsException        If a car already exists during car addition.
     * @throws LeaseNotFoundException           If a lease is not found during lease-related operations.
     */
    public static void main(String[] args)
            throws CarNotFoundException, CustomerAlreadyExistsException, CustomerNotFoundException,
            CarAlreadyExistsException, LeaseNotFoundException {

    	while (true) {

    		System.out.println("Car Rental Application Menu:");
            System.out.println("1. Customer Management");
            System.out.println("2. Car Management");
            System.out.println("3. Lease Management");
            System.out.println("4. Payment Handling");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customerManagementMenu();
                    break;
                case 2:
                    carManagementMenu();
                    break;
                case 3:
                    leaseManagementMenu();
                    break;
                case 4:
                    paymentHandlingMenu();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    /**
     * Handles the Customer Management menu, providing options for adding, removing, listing, and finding customers.
     *
     * @throws CustomerNotFoundException If a customer is not found during customer-related operations.
     */
    
    private static void customerManagementMenu() throws CustomerNotFoundException {
        while (true) {
            System.out.println("\nCustomer Management Menu:");
            System.out.println("1. Add New Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. List Customers");
            System.out.println("4. Find Customer by ID");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    removeCustomer();
                    break;
                case 3:
                    listCustomers();
                    break;
                case 4:
                    findCustomerById();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    /**
     * Adds a new customer to the system by taking user input for customer details.
     * Calls the addCustomer method in CarRentalController to perform the addition.
     */
    
    private static void addCustomer() {
        System.out.println("\nAdding Customer:");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID: ");
        int customerID = scanner.nextInt();
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter phone number: ");
        String phone_num = scanner.next();

        Customer newCustomer = new Customer(customerID, firstName, lastName, email, phone_num);

        carRentalController.addCustomer(newCustomer);
    }

    /**
     * Removes a customer from the system by taking user input for the customer ID.
     * Calls the removeCustomer method in CarRentalController to perform the removal.
     */
    
    private static void removeCustomer() {
        System.out.println("\nRemoving Customer:");
        System.out.print("Enter customer ID to remove: ");
        int customerID = scanner.nextInt();

        carRentalController.removeCustomer(customerID);
    }

    /**
     * Lists all customers in the system.
     * Calls the listCustomers method in CarRentalController to retrieve and display the list.
     */
    
    private static void listCustomers() {
        System.out.println("\nList of Customers:");
        List<Customer> customers = carRentalController.listCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * Finds and displays a customer based on the user input for the customer ID.
     * Calls the findCustomerById method in CarRentalController for customer retrieval.
     *
     * @throws CustomerNotFoundException If the specified customer is not found.
     */
    
    private static void findCustomerById() throws CustomerNotFoundException {
        System.out.println("\nFind Customer by ID:");
        System.out.print("Enter customer ID to find: ");
        int customerID = scanner.nextInt();

       carRentalController.findCustomerById(customerID);
    }

    /**
     * Handles the Car Management menu, providing options for adding, removing, listing, and finding cars.
     *
     * @throws CarNotFoundException       If a car is not found during processing.
     * @throws CarAlreadyExistsException  If a car already exists during car addition.
     * @throws CustomerAlreadyExistsException If a customer already exists during customer addition.
     */
    
    private static void carManagementMenu()
            throws CarNotFoundException, CarAlreadyExistsException, CustomerAlreadyExistsException {
        while (true) {
            System.out.println("\nCar Management Menu:");
            System.out.println("1. Add New Car");
            System.out.println("2. Remove Car");
            System.out.println("3. List Available Cars");
            System.out.println("4. List Rented Cars");
            System.out.println("5. Find Car by ID");
            System.out.println("6. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    removeCar();
                    break;
                case 3:
                    listAvailableCars();
                    break;
                case 4:
                    listRentedCars();
                    break;
                case 5:
                    findCarById();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    /**
     * Adds a new car to the system by taking user input for car details.
     * Calls the addCar method in CarRentalController to perform the addition.
     *
     * @throws CarAlreadyExistsException If a car with the specified ID already exists.
     * @throws CustomerAlreadyExistsException If a customer with the specified ID already exists.
     */
    
    private static void addCar() throws CarAlreadyExistsException, CustomerAlreadyExistsException {
        System.out.println("\nAdding Car:");

        scanner.nextLine(); 

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        System.out.print("Enter daily rate: ");
        double dailyRate = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Enter status (available, notAvailable): ");
        String status = scanner.nextLine();

        System.out.print("Enter passenger capacity: ");
        int passengerCapacity = scanner.nextInt();

        System.out.print("Enter engine capacity: ");
        int engineCapacity = scanner.nextInt();

        // Create a Car object with the entered data
        Car newCar = new Car(0, make, model, year, dailyRate, status, passengerCapacity, engineCapacity);

        carRentalController.addCar(newCar);
		System.out.println("Car added successfully.");
    }


        /**
         * Removes a car from the system by taking user input for the car ID.
         * Calls the removeCar method in CarRentalController to perform the removal.
         *
         * @throws CarNotFoundException If the specified car is not found in the system.
         */
    
        private static void removeCar() throws CarNotFoundException {
            System.out.println("\nRemoving Car:");
            System.out.print("Enter car ID to remove: ");
            int carID = scanner.nextInt();
            carRentalController.removeCar(carID);
        }

        /**
         * Lists all available cars in the system.
         * Calls the listAvailableCars method in CarRentalController to retrieve and display the list.
         */
        
        private static void listAvailableCars() {
            System.out.println("\nList of Available Cars:");
            List<Car> availableCars = carRentalController.listAvailableCars();
            for (Car car : availableCars) {
                System.out.println(car);
            }
        }

        /**
         * Lists all rented cars in the system.
         * Calls the listRentedCars method in CarRentalController to retrieve and display the list.
         */
        
        private static void listRentedCars() {
            System.out.println("\nList of Rented Cars:");
            List<Car> rentedCars = carRentalController.listRentedCars();
            for (Car car : rentedCars) {
                System.out.println(car);
            }
        }

        /**
         * Finds and displays a car based on the user input for the car ID.
         * Calls the findCarById method in CarRentalController for car retrieval.
         *
         * @throws CarNotFoundException If the specified car is not found.
         */
        
        private static void findCarById() throws CarNotFoundException {
            System.out.println("\nFind Car by ID:");
            System.out.print("Enter car ID to find: ");
            int carID = scanner.nextInt();

            Car car = carRentalController.findCarById(carID);
            System.out.println("Car found:\n" + car);
        }

        /**
         * Handles the Lease Management menu, providing options for creating leases, returning cars,
         * and listing active leases and lease history.
         *
         * @throws LeaseNotFoundException If a lease is not found during lease-related operations.
         * @throws CustomerNotFoundException 
         * @throws CarNotFoundException 
         */
        
        private static void leaseManagementMenu() throws LeaseNotFoundException, CarNotFoundException, CustomerNotFoundException {
            while (true) {
                System.out.println("\nLease Management Menu:");
                System.out.println("1. Create Lease");
                System.out.println("2. Return Car");
                System.out.println("3. List Active Leases");
                System.out.println("4. List Lease History");
                System.out.println("5. Back to Main Menu");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        createLease();
                        break;
                    case 2:
                        returnCar();
                        break;
                    case 3:
                        listActiveLeases();
                        break;
                    case 4:
                        listLeaseHistory();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }

        /**
         * Creates a new lease by taking user input for customer ID, car ID, start date, and end date.
         * Calls the createLease method in CarRentalController to perform the lease creation.
         */
        
        private static void createLease() {
            System.out.println("\nCreating Lease:");

            System.out.print("Enter customer ID: ");
            int customerID = scanner.nextInt();
            System.out.print("Enter car ID: ");
            int carID = scanner.nextInt();
            System.out.print("Enter start date (yyyy-MM-dd): ");
            String startDateStr = scanner.next();
            System.out.print("Enter end date (yyyy-MM-dd): ");
            String endDateStr = scanner.next();

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = dateFormat.parse(startDateStr);
                Date endDate = dateFormat.parse(endDateStr);

                Lease lease = carRentalController.createLease(customerID, carID, startDate, endDate);
                System.out.println("Lease created successfully:\n" + lease);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter dates in yyyy-MM-dd format.");
            }
        }

        /**
         * Returns a leased car by taking user input for the lease ID.
         * Calls the returnCar method in CarRentalController to perform the car return.
         *
         * @throws LeaseNotFoundException If the specified lease is not found.
         * @throws CustomerNotFoundException 
         * @throws CarNotFoundException 
         */
        
        private static void returnCar() throws LeaseNotFoundException, CarNotFoundException, CustomerNotFoundException {
            System.out.println("\nReturning Car:");
            System.out.print("Enter lease ID to return: ");
            int leaseID = scanner.nextInt();

            carRentalController.returnCar(leaseID);
        }

        /**
         * Lists all active leases in the system.
         * Calls the listActiveLeases method in CarRentalController to retrieve and display the list.
         */
        
        private static void listActiveLeases() {
            System.out.println("\nList of Active Leases:");
            List<Lease> activeLeases = carRentalController.listActiveLeases();
            for (Lease lease : activeLeases) {
                System.out.println(lease);
            }
        }

        /**
         * Lists the lease history in the system.
         * Calls the listLeaseHistory method in CarRentalController to retrieve and display the list.
         */
        
        private static void listLeaseHistory() {
            System.out.println("\nList of Lease History:");
            List<Lease> leaseHistory = carRentalController.listLeaseHistory();
            for (Lease lease : leaseHistory) {
                System.out.println(lease);
            }
        }

        /**
         * Handles the Payment Handling menu, providing options for recording payments,
         * retrieving payment history, and calculating total revenue.
         *
         * @throws CustomerNotFoundException If the specified customer is not found during payment-related operations.
         * @throws CarNotFoundException 
         */
        
        private static void paymentHandlingMenu() throws CustomerNotFoundException, CarNotFoundException {
            while (true) {
                System.out.println("\nPayment Handling Menu:");
                System.out.println("1. Record Payment");
                System.out.println("2. Retrieve Payment History");
                System.out.println("3. Calculate Total Revenue");
                System.out.println("4. Back to Main Menu");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        recordPayment();
                        break;
                    case 2:
                        retrievePaymentHistory();
                        break;
                    case 3:
                        calculateTotalRevenue();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }

        /**
         * Records a payment by taking user input for lease ID and payment amount.
         * Calls the recordPayment method in CarRentalController to perform the payment recording.
         * @throws CustomerNotFoundException 
         * @throws CarNotFoundException 
         */
        
        private static void recordPayment() throws CarNotFoundException, CustomerNotFoundException {
            System.out.println("\nRecording Payment:");
            System.out.print("Enter Lease ID: ");
            int leaseID = scanner.nextInt();
            System.out.print("Enter payment amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); 

            try {
                Lease lease = carRentalController.findLeaseById(leaseID); // Retrieve Lease object
                carRentalController.recordPayment(lease, amount); // Record payment
            } catch (LeaseNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * Retrieves the payment history for a customer based on user input for the customer ID.
         * Calls the retrievePaymentHistory method in CarRentalController for payment history retrieval.
         *
         * @throws CustomerNotFoundException If the specified customer is not found.
         */
        
        private static void retrievePaymentHistory() throws CustomerNotFoundException {
            System.out.println("\nRetrieving Payment History:");
            System.out.print("Enter Customer ID: ");
            int customerID = scanner.nextInt();
            scanner.nextLine(); 

            List<Payment> paymentHistory = carRentalController.retrievePaymentHistory(customerID);
            System.out.println("Payment History for Customer ID " + customerID + ":");
            for (Payment payment : paymentHistory) {
                System.out.println(payment);
            }
        }

        /**
         * Calculates and displays the total revenue earned by the car rental service.
         * Calls the calculateTotalRevenue method in CarRentalController for revenue calculation.
         */
        
        private static void calculateTotalRevenue() {
            System.out.println("\nCalculating Total Revenue:");
            double totalRevenue = carRentalController.calculateTotalRevenue();
            System.out.println("Total Revenue: Rs " + totalRevenue);
        }
    }

