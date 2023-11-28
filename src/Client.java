import java.util.ArrayList;
import java.time.*;

/**
 * child class of "Person"
 * @author Philipp Immler, Nico Lang
 */
public class Client extends Person{
	private static int idx;
	private int clientID;
	private ArrayList<DriversLicenceClass> driversLicenceClassList;

	/**
	 * constructor
	 * idx is increased every time a new person is created
	 * @param firstName => see "Person" class
	 * @param lastName => see "Person" class
	 * @param birthDate => see "Person" class
	 * @param gender => see "Person" class
	 * @param address => see "Person" class
	 * @param email => see "Person" class
	 * @param tel => see "Person" class
	 * @param driversLicenceClassList a list of all driverslicence classes the client has
	 * @return the "Client" object
	 */
	public Client(String firstName, String lastName, LocalDate birthDate, Gender gender, String address, String email,
			String tel, ArrayList<DriversLicenceClass> driversLicenceClassList) {
		super(firstName, lastName, birthDate, gender, address, email, tel);
		this.setClientID(idx);
		idx++;
		this.driversLicenceClassList = driversLicenceClassList;
	}

	/**
	 * getters and setters
	 */
	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public ArrayList<DriversLicenceClass> getDriversLicenceClassList() {
		return driversLicenceClassList;
	}

	public void setDriversLicenceClassList(ArrayList<DriversLicenceClass> driversLicenceClassList) {
		this.driversLicenceClassList = driversLicenceClassList;
	}

	/**
	 * adds a driverslicence class to the list of driverslicence classes
	 * @param driversLicenceClass the driverslicence class which should be added to the list
	 */
	public void addDriversLicenceClass(DriversLicenceClass driversLicenceClass) {
		driversLicenceClassList.add(driversLicenceClass);
	}
	/**
	 * removes a driverslicence class from the list of driverslicence classes
	 * @param driversLicenceClass the driverslicence class which should be removed from the list
	 */
	public void removeDriversLicenceClass(DriversLicenceClass driversLicenceClass) {
		driversLicenceClassList.remove(driversLicenceClass);
	}

	/**
	 * toString method
	 * @return a String with all attributes of the "Client" and "Person" object
	 */
	@Override
	public String toString() {
		return "Client [" + super.toString() + " clientID=" + clientID + ", driversLicenceList=" + driversLicenceClassList + "]";
	}
}
