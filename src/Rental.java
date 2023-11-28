import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Initialises the "Rental" object
 * all vehicles, clients, employees and reservation are saved here
 * @author Philipp Immler, Nico Lang
 */
public class Rental {
	private String name;
	private String address;
	private ArrayList<Vehicle> vehicleList;
	private ArrayList<Client> clientList;
	private ArrayList<Employee> employeeList;
	private ArrayList<Reservation> reservationList;

	/**
	 * constructor
	 * @param name the name of the rental (e.g. "Lang Rental")
	 * @param address the address of the rental (street, street number, postcode, city)
	 */
	public Rental(String name, String address) {
		this.name = name;
		this.address = address;
		vehicleList = new ArrayList<>();
		clientList = new ArrayList<>();
		employeeList = new ArrayList<>();
		reservationList = new ArrayList<>();
	}

	/**
	 * getters and setters
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * adds a vehicle to the list of vehicles
	 * @param vehicle vehicle which should be added to the list of vehicles
	 */
	public void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}

	/**
	 * removes a vehicle from the list of vehicles
	 * @param vehicle vehicle which should be removed from the list of vehicles
	 */
	public void removeVehicle(Vehicle vehicle) {
		vehicleList.remove(vehicle);
	}

	/**
	 * removes a vehicle from the list of vehicles
	 * @param vehicleID id of the vehicle which should be removed from the list of vehicles
	 */
	public void removeVehicle(int vehicleID) {
		for(Vehicle vehicle : vehicleList) {
			if(vehicle.getVehicleID() == vehicleID) {
				vehicleList.remove(vehicle);
			}
		}
	}

	/**
	 * adds a client to the list of clients
	 * @param client client which should be added to the list of clients
	 */
	public void addClient(Client client) {
		clientList.add(client);
	}
	/**
	 * removes a client from the list of clients
	 * @param client client which should be removed from the list of clients
	 */
	public void removeClient(Client client) {
		clientList.remove(client);
	}
	/**
	 * removes a client from the list of clients
	 * @param clientID id of the client which should be removed from the list of clients
	 */
	public void removeClient(int clientID) {
		for(Client client : clientList) {
			if(client.getClientID() == clientID) {
				clientList.remove(client);
			}
		}
	}
	/**
	 * adds an employee to the list of employees
	 * @param employee employee which should be added to the list of employees
	 */
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	/**
	 * removes an employee from the list of employees
	 * @param employee which should be removed from the list of employees
	 */
	public void removeEmployee(Employee employee) {
		employeeList.remove(employee);
	}
	/**
	 * removes an employee from the list of employees
	 * @param employeeID id of the employee which should be removed from the list of employees
	 */
	public void removeEmployee(int employeeID) {
		for(Employee employee : employeeList) {
			if(employee.getEmployeeID() == employeeID) {
				employeeList.remove(employee);
			}
		}
	}
	/**
	 * adds a reservation to the list of reservations
	 * @param reservation reservation object which should be added to the list of reservations
	 */
	public void addReservation(Reservation reservation) {
		reservationList.add(reservation);
	}
	/**
	 * removes a reservation from the list of reservations
	 * @param reservation object which should be removed from the list of reservations
	 */
	public void removeReservation(Reservation reservation) {
		reservationList.remove(reservation);
	}
	/**
	 * removes a reservation from the list of reservations
	 * @param reservationID id of the reservation which should be removed from the list of reservations
	 */
	public void removeReservation(int reservationID) {
		for(Reservation reservation : reservationList) {
			if(reservation.getReservationID() == reservationID) {
				reservationList.remove(reservation);
			}
		}
	}

	/**
	 * calculates the sales volume of the current day
	 * @return sales volume of the current day as a double
	 */
	public double getDailySalesVolume() {
		double sum = 0;
		for(Reservation reservation : reservationList) {
			if(reservation.isCompleted() && !reservation.isCancelled() && reservation.getEndDateTime().toLocalDate().equals(LocalDateTime.now().toLocalDate())) {
					sum += reservation.getPrice();
				}
			}
		return sum;
	}

	/**
	 * calculates the whole sales volume
	 * @return whole sales volume of the rental
	 */
	public double getOverallSalesVolume() {
		double sum = 0;
		for(Reservation reservation : reservationList) {
			if(reservation.isCompleted() && !reservation.isCancelled()) {
					sum += reservation.getPrice();
				}
			}
		return sum;
	}

	/**
	 * looks if a vehicle is available in a specific timespan
	 * @param vehicle vehicle for comparison
	 * @param start start datetime of the timespan
	 * @param end end datetime of the timespan
	 * @return true => the vehicle is available in this timespan, false => the vehicle is not available in this timespan
	 */
	public boolean isVehicleAvailableBetween(Vehicle vehicle, LocalDateTime start, LocalDateTime end){
		for(Reservation reservation : reservationList){
			if(reservation.getVehicle() == vehicle && reservation.getVehicle().isAvailable() && reservation.isBetween(start, end)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Searches for all available vehicles in a specific timespan from a specific category
	 * @param start start datetime of the timespan
	 * @param end end datetime of the timespan
	 * @param vehicleCategory vehicleCategory of the vehicles we are searching for
	 * @return a list of available vehicles in the given timespan from the given category
	 */
	public ArrayList<Vehicle> getAvailableVehicles(LocalDateTime start, LocalDateTime end, VehicleCategory vehicleCategory){
		ArrayList<Vehicle> availableVehicleList = new ArrayList<>();
		for(Vehicle vehicle : vehicleList){
			if(vehicle.getCategory() == vehicleCategory && isVehicleAvailableBetween(vehicle, start, end)){
				availableVehicleList.add(vehicle);
			}
		}
		return availableVehicleList;
	}

	/**
	 * calculates the whole sales volume of a specific employee
	 * @param employee employee, to calculate the whole sales volume from
	 * @return whole sales volume of the given employee
	 */
	public double getSalesVolumeOfEmployee(Employee employee){
		double sum = 0;
		for(Reservation reservation : reservationList){
			if(reservation.isCompleted() && reservation.getEmployee() == employee){
				sum += reservation.getPrice();
			}
		}
		return sum;
	}

	/**
	 * calculates the sales volume of a spcific employee in a specific timespan
	 * @param employee employee, to calculate the sales volume from
	 * @param start start datetime of the specific timespan
	 * @param end end datetime of the specific timespan
	 * @return sales volume of the given employee in the given timespan
	 */
	public double getSalesVolumeOfEmployee(Employee employee, LocalDateTime start, LocalDateTime end){
		double sum = 0;
		for(Reservation reservation : reservationList){
			if(reservation.isCompleted() && reservation.getEmployee() == employee && reservation.isBetween(start, end)){
				sum += reservation.getPrice();
			}
		}
		return sum;
	}
}