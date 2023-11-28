import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * class for testing
 * @author Philipp Immler, Nico Lang
 */
public class Test {

	public static void main(String[] args) {
		Rental r = new Rental("Vermietung Lang", "Grießau 33, 6651 Häsergehr");
		
		Vehicle v1 = new Vehicle("VW", "Polo", LocalDate.of(2005, 3, 12), true, VehicleCategory.CAR, 2.5);
		Vehicle v2 = new Vehicle("Kawasaki", "Ninja", LocalDate.of(2017, 5, 20), true, VehicleCategory.MOTORBIKE, 7.3);
		Vehicle v3 = new Vehicle("MAN", "TGX", LocalDate.of(2020, 12, 3), true, VehicleCategory.TRUCK, 15);
		Vehicle v4 = new Vehicle("Trek", "Slash 8", LocalDate.of(2018, 3, 9), true, VehicleCategory.BICYCLE, 1);
		Vehicle v5 = new Vehicle("Aprilia", "Classic 50", LocalDate.of(2017, 5, 20), true, VehicleCategory.MOPED, 1.5);
		
		Employee e1 = new Employee("Nico", "Lang", LocalDate.of(2006, 7, 16), Gender.MALE, "Grießau 33, 6651 Häselgehr", "nicolang@aon.at", "+43 677 62482500");
		Employee e2 = new Employee("Philipp", "Immler", LocalDate.of(2006, 3, 23), Gender.MALE, "Hoheneggweg 21a, 6682 Vils", "pimmler@tsn.at", "+43 650 3067608");
		
		ArrayList<DriversLicenceClass> driversLicenceClasses = new ArrayList<>();
		driversLicenceClasses.add(DriversLicenceClass.A);
		driversLicenceClasses.add(DriversLicenceClass.B);
		driversLicenceClasses.add(DriversLicenceClass.AM);
		driversLicenceClasses.add(DriversLicenceClass.F);
		Client c1 = new Client("Gernot", "Reichelt", LocalDate.of(1988, 10, 5), Gender.MALE, "Brunnenstraße 3, 6600 Reutte", "reichelt.gernot@gmail.com", "+43 677 5804561", driversLicenceClasses);
		driversLicenceClasses.remove(DriversLicenceClass.A);
		driversLicenceClasses.remove(DriversLicenceClass.F);
		Client c2 = new Client("Lukas", "Singer", LocalDate.of(2006, 3, 8), Gender.MALE, "Blockau 3, 6642 Stanzach", "lukas.singer@gmail.com", "+43 677 4561235", driversLicenceClasses);
		
		//Client client, Vehicle vehicle, LocalDateTime startDateTime, LocalDateTime endDateTime, Employee employee
		Reservation r1 = new Reservation(c1, v1, LocalDateTime.of(2023, 11, 25, 12, 0, 0), LocalDateTime.of(2023, 11, 30, 12, 0, 0), e1);
		Reservation r2 = new Reservation(c2, v4, LocalDateTime.now(), LocalDateTime.of(2023,12,1, 10, 0, 0), e2);
		//testing methods

	}	

}
