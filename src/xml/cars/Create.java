package xml.cars;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Create {
	
	public static void run(List<Car> cars) {
		
		try {
			// root element
			Element carsElement = new Element("cars");
			Document doc = new Document(carsElement);

			for (Car car: cars)
			{
				Element carElement = new Element("car");
				Element manufacturer = new Element("manufacturer");
				Element model = new Element("model");
				Element year = new Element("year");
				Element plate = new Element("licensePlate");
				Element plateNumber = new Element("number");
				Element plateColor = new Element("color");
				plateNumber.setText(String.valueOf(car.plate.number));
				plateColor.setText(car.plate.color);
				manufacturer.setText(car.manufacturer);
				model.setText(car.model);
				year.setText(String.valueOf(car.year));
				plate.addContent(List.of(plateNumber, plateColor));
				carElement.addContent(List.of(manufacturer, model, year, plate));
				carsElement.addContent(carElement);
			}

			XMLOutputter xmlOutput = new XMLOutputter();

			// display format
			xmlOutput.setFormat(Format.getPrettyFormat());
			// save to a file
			File outputFile = new File("files/cars.xml");
			OutputStream outputStream = new FileOutputStream(outputFile);
			xmlOutput.output(doc, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
