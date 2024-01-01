package entity;

import java.util.Date;

/**
 * The {@code Lease} class represents a lease agreement in a car rental system.
 * It contains information about the lease, including its identification,
 * associated vehicle, customer, start date, end date, and type.
 */
public class Lease {

    /**
     * The unique identifier for the lease.
     */
    private int leaseID;

    /**
     * The identifier of the leased vehicle.
     */
    private int vehicleID;

    /**
     * The identifier of the customer associated with the lease.
     */
    private int customerID;

    /**
     * The start date of the lease.
     */
    private Date startDate;

    /**
     * The end date of the lease.
     */
    private Date endDate;

    /**
     * The type of the lease (e.g., daily, weekly).
     */
    private String type;

    /**
     * Constructs a new Lease object with the specified parameters.
     *
     * @param leaseID    The unique identifier for the lease.
     * @param vehicleID  The identifier of the leased vehicle.
     * @param customerID The identifier of the customer associated with the lease.
     * @param startDate  The start date of the lease.
     * @param endDate    The end date of the lease.
     * @param type       The type of the lease (e.g., daily, weekly).
     */
    public Lease(int leaseID, int vehicleID, int customerID, Date startDate, Date endDate, String type) {
        this.leaseID = leaseID;
        this.vehicleID = vehicleID;
        this.customerID = customerID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    /**
     * Retrieves the unique identifier for the lease.
     *
     * @return The lease ID.
     */
    public int getLeaseID() {
        return leaseID;
    }

    /**
     * Sets the unique identifier for the lease.
     *
     * @param leaseID The lease ID to set.
     */
    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }

    /**
     * Retrieves the identifier of the leased vehicle.
     *
     * @return The vehicle ID.
     */
    public int getVehicleID() {
        return vehicleID;
    }

    /**
     * Sets the identifier of the leased vehicle.
     *
     * @param vehicleID The vehicle ID to set.
     */
    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    /**
     * Retrieves the identifier of the customer associated with the lease.
     *
     * @return The customer ID.
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Sets the identifier of the customer associated with the lease.
     *
     * @param customerID The customer ID to set.
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Retrieves the start date of the lease.
     *
     * @return The start date of the lease.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the lease.
     *
     * @param startDate The start date to set.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Retrieves the end date of the lease.
     *
     * @return The end date of the lease.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the lease.
     *
     * @param endDate The end date to set.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Retrieves the type of the lease.
     *
     * @return The type of the lease.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the lease.
     *
     * @param type The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns a string representation of the Lease object.
     *
     * @return A string representation of the Lease object.
     */
    @Override
    public String toString() {
        return "Lease{" +
                "leaseID=" + leaseID +
                ", vehicleID=" + vehicleID +
                ", customerID=" + customerID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", type='" + type + '\'' +
                '}';
    }
}
