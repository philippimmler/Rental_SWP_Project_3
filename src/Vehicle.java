import java.time.*;

/**
 * initialises the "Vehicle" object
 * @author Philipp Immler, Nico Lang
 */
public class Vehicle {
	private static int idx;
	private int vehicleID;
	private String brand;
	private String model;
	private DriversLicenceClass driversLicenceClassNeeded;
	private LocalDate buildDate;
	private boolean available;
	private VehicleCategory category;
	private double pricePerHour;

	/**
	 * constructor
	 * idx is increased every time a new vehicle is created
	 * the needed driverslicence class is set automatically depending on the category (e.q. car => B)
	 * @param brand brand of the vehicle (e.g. "Audi")
	 * @param model model of the vehicle (e.g. "A4")
	 * @param buildDate build date of the vehicle (e.g. "20.10.2019)
	 * @param available says if the vehicle is available or not (true, false)
	 * @param category category of the vehicle (car, bicycle, truck, motorbike, moped)
	 * @param pricePerHour price of the vehicle per hour (e.q. "3€")
	 */
	public Vehicle(String brand, String model, LocalDate buildDate, boolean available, VehicleCategory category, double pricePerHour) {
		super();
		this.setVehicleID(idx);
		idx++;
		this.brand = brand;
		this.model = model;
		this.buildDate = buildDate;
		this.available = available;
		this.category = category;
		this.pricePerHour = pricePerHour;

		switch(category) {
			case CAR:
				driversLicenceClassNeeded = DriversLicenceClass.B;
				break;
			case TRUCK:
				driversLicenceClassNeeded = DriversLicenceClass.C;
				break;
			case MOTORBIKE:
				driversLicenceClassNeeded = DriversLicenceClass.A;
				break;
			case BICYCLE:
				driversLicenceClassNeeded = DriversLicenceClass.NO;
				break;
			case MOPED:
				driversLicenceClassNeeded = DriversLicenceClass.AM;
				break;
		}
	}

	/**
	 * getters and setters
	 */
	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public DriversLicenceClass getDriversLicenceClassNeeded() {
		return driversLicenceClassNeeded;
	}

	public void setDriversLicenceClassNeeded(DriversLicenceClass driversLicenceClassNeeded) {
		this.driversLicenceClassNeeded = driversLicenceClassNeeded;
	}

	public LocalDate getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(LocalDate buildDate) {
		this.buildDate = buildDate;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public VehicleCategory getCategory() {
		return category;
	}

	public void setCategory(VehicleCategory category) {
		this.category = category;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
	/*public boolean equals(Vehicle vehicle) {
		return this.getVehicleID() == vehicle.getVehicleID();
	}*/

	/**
	 * toString method
	 * @return string with all attributes from the "Vehicle" class
	 */
	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", brand=" + brand + ", model=" + model
				+ ", driversLicenceClassNeeded=" + driversLicenceClassNeeded + ", buildDate=" + buildDate
				+ ", available=" + available + ", category=" + category + ", pricePerHour=" + pricePerHour + "]";
	}
}
