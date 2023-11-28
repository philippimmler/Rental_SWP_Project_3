import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * intialises the "Reservation" object
 * clients can reserve one vehicle over a defined timespan
 * they must have the needed driverslicence class for the vehicle
 * @author Philipp Immler, Nico Lang
 */

public class Reservation {
	private static int idx;
	private int reservationID;
	private Client client;
	private Vehicle vehicle;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private boolean completed;
	private boolean cancelled;
	private Employee employee;

	/**
	 * constructor
	 * idx is increased every time a new vehicle is created
	 * Reservation can only be created when the client is 18+
	 * @param client the client which wants to reserve a vehicle
	 * @param vehicle the vehicle which should be reservated
	 * @param startDateTime the datetime in which the rent starts
	 * @param endDateTime the datetime in which the rent ends
	 * @param employee the employee which creates the reservation
	 */
	public Reservation(Client client, Vehicle vehicle, LocalDateTime startDateTime, LocalDateTime endDateTime, Employee employee) {
		if(client.getAge() >= 18) {
			this.setReservationID(idx);
			idx++;
			this.client = client;
			this.vehicle = vehicle;
			this.startDateTime = startDateTime;
			this.endDateTime = endDateTime;
			this.employee = employee;
			this.completed = false;
			this.cancelled = false;
		} else {
			System.err.println("The client have to be at least 18 years old to make a reservation");
		}
	}

	/**
	 * getters and setters
	 */
	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDate(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.vehicle.setAvailable(true);
		this.completed = completed;
	}
	
	public Vehicle getVehicle(){
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isCancelled(){
		return cancelled;
	}

	/**
	 * calulates the time how long the vehicle is rented by the client (in hours)
	 * @return renttime in hours as an int
	 */
	public int getRentedHours() {
		return (int) Duration.between(startDateTime, endDateTime).toHours();
	}

	/**
	 * calculates the whole price of the rent
	 * @return whole price of the rent as a double
	 */
	public double getPrice() {
		return this.getRentedHours()*this.vehicle.getPricePerHour();
	}

	/**
	 * cancels a reservation
	 * if the cancellation datetime is at least two weeks before the rent datetime it is free
	 * if the cancellation dattime is less than two weeks before the rent datetime the clients have to a cancellation fee which is 13% of the rent price
	 * @return cancellation fee as a double
	 */
	public double cancel() {
		this.cancelled = true;
		if(LocalDateTime.now().isBefore(startDateTime.minus(2, ChronoUnit.WEEKS))){ //if the datetime of the cancellation is at least two weeks before the start datetime of the reservation, then there is no cancellation charge
			this.setCompleted(true);
			return 0;
		} else { //else the cancellation charge is 13% of the price
			this.setCompleted(false);
			return this.getPrice()*0.13;
		}
	}

	public boolean isBetween(LocalDateTime start, LocalDateTime end){
		if(startDateTime.isAfter(start) || startDateTime.equals(start) && endDateTime.isBefore(end) ||endDateTime.equals(end)){
			return true;
		}
		return false;
	}

	/**
	 * toString method
	 * @return String with all attributes of the "Reservation" object
	 */
	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", client=" + client + ", vehicle=" + vehicle + ", startDateTime="
				+ startDateTime + ", endDateTime=" + endDateTime + ", completed=" + completed + ", cancelled="
				+ cancelled + ", employee=" + employee + "]";
	}
}