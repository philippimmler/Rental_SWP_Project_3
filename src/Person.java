import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author Philipp Immler, Nico Lang
 */
public class Person {
	/**
	 * common attributes for every person
	 */
	private String firstName;
	private String lastName;
	private LocalDate birthDate;	
	private Gender gender;
	private String address;
	private String email;
	private String tel;

	/**
	 * constuctor
	 * @param firstName first name of the person (e.g. "Philipp")
	 * @param lastName last name of the person (e.g. "Immler")
	 * @param birthDate birthDate of the person (e.q. "23.03.2006")
	 * @param gender gender of the person (male, female, divers)
	 * @param address address of the person (street, street number, postcode, city)
	 * @param email email of the person (e.g. "pimmler@tsn.at")
	 * @param tel telephone number of the person (e.g. "+43 650 3067608");
	 * @return the "Person" object
	 */
	public Person(String firstName, String lastName, LocalDate birthDate, Gender gender, String address, String email,
			String tel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.tel = tel;
	}

	/**
	 * getters and setters
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * calculates the age of the person
	 * @return age of the person as an int
	 */
	public int getAge(){
		return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
	}

	/**
	 * toString method
	 *  @return a String with all attributes of the "Person" object
	 */
	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", gender="
				+ gender + ", address=" + address + ", email=" + email + ", tel=" + tel;
	}
}