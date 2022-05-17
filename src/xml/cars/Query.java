package xml.cars;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Query {

	public static List<Car> run() {
		
		List<Car> cars = new ArrayList<>();
		
		try {
			File inputFile = new File("files/cars.xml");
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(inputFile);
			Element carsElement = document.getRootElement();

			List<Element> carsList = carsElement.getChildren();

			for (int i = 0; i < carsList.size(); i++) {
				Element car = carsList.get(i);
				Car tmp = parseCar(car);
				List<LicensePlate> allPlates = cars.stream().map(c->c.getPlate()).collect(Collectors.toList());
				if (!allPlates.contains(tmp.plate))
					cars.add(tmp);
			}
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return cars;

	}
	

	private static Car parseCar(Element car) {

		String manufacturer = car.getChild("manufacturer").getText();
		String model = car.getChild("model").getText();
		int year =  Integer.parseInt(car.getChild("year").getText());
		int plateNumber = Integer.parseInt(car.getChild("licensePlate").getChildText("number"));
		String plateColor = car.getChild("licensePlate").getChildText("color");
		LicensePlate plate = new LicensePlate(plateNumber, plateColor);
		return new Car(manufacturer, model, year, plate);
	}
}
