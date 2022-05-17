package xml.cars;

public class Car {
	
	protected String manufacturer;
	protected String model;
	protected int year;
	protected LicensePlate plate;
	
	public Car(String manufacturer, String model, int year, LicensePlate plate) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.plate = plate;
	}

	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", model=" + model + ", year=" + year + ", plate=" + plate + "]";
	}

	public LicensePlate getPlate() {
		return plate;
	}


	
	

}
