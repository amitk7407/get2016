package DefaultNamespace;

import java.util.Scanner;

/**
 * client class to use the web service to convert fahrenheit to celcius
 */
public class WSClient {
	
	public static void main(String[] args) {
		
		TemperatureConversion temp = null;
		try {
	
			//a TemperatureConversionServiceLocator object is created
			TemperatureConversionServiceLocator conversionServiceLocator = new TemperatureConversionServiceLocator();
			//The web service endpoint address is assigned to the locator object
			conversionServiceLocator.setTemperatureConversionEndpointAddress("http://localhost:8080/SOAPservices/services/TemperatureConversion");
			//TemperatureConversion object is fetched from the web service
			temp = new TemperatureConversionServiceLocator().getTemperatureConversion();

			System.out.print("Enter the temperature in Fahrenheit: ");
			Scanner sc= new Scanner(System.in);
			int temperature = sc.nextInt();
			//method is called which convert fahrenheit to celcius
			System.out.println("Temperature in celcius is: "+temp.fahrenheitToCelcius(temperature));
		} catch(Exception e) {
			
			e.printStackTrace();
		}	
	}
}