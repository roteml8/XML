package xml.cars;

import java.util.Objects;

public class LicensePlate {
	
	protected int number;
	protected String color;
	private static int counter = 0;
	
	
	public LicensePlate(String color) {
		this.number = counter++;
		this.color = color;
	}
	

	public LicensePlate(int number, String color) {
		this.number = number;
		this.color = color;
	}


	@Override
	public String toString() {
		return "LicensePlate [number=" + number + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LicensePlate other = (LicensePlate) obj;
		return Objects.equals(color, other.color) && number == other.number;
	}
	
	
	
	

}
