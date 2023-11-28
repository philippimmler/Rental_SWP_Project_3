import java.time.*;

/**
 * child class of "Person"
 * @author Philipp Immler, Nico Lang
 */
public class Employee extends Person{
	private static int idx;
	private int employeeID;
	private double salesVolume;

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
	 * @return the "Employee" object
	 */
	public Employee(String firstName, String lastName, LocalDate birthDate, Gender gender, String address, String email,
			String tel) {
		super(firstName, lastName, birthDate, gender, address, email, tel);
		this.setEmployeeID(idx);
		idx++;
	}

	/**
	 * getters and setters
	 */

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public double getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(double salesVolume) {
		this.salesVolume = salesVolume;
	}

	/**
	 * toString method
	 * @return a String with all attributes of the "Employee" and "Person" object
	 */
	@Override
	public String toString() {
		return "Employee [" + super.toString() + " employeeID=" + employeeID + ", salesVolume=" + salesVolume + "]";
	}
}
