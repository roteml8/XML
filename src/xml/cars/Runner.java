package xml.cars;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		List<Car> carsList = new ArrayList<>();
		carsList.add(new Car("Tesla","XR",2022, new LicensePlate("Purple")));
		carsList.add(new Car("Toyota", "S132", 2000, new LicensePlate("Red")));
		Create.run(carsList);
		
		List<Car> carsFromFile = Query.run();
		carsFromFile.forEach(System.out::println);

	}

}
