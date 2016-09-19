import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * class to convert the temperature from fahrenheit to celcius
 */
@WebService
public class TemperatureConversion {

	/**
	 * method to convert the temperature from fahrenheit to celcius
	 * @param fahrenheit : temperature in fahrenheit
	 * @return float : temperature in celcius
	 */
	@WebMethod
	public float fahrenheitToCelcius(float fahrenheit) {
		return (fahrenheit - 32)*5/9;
	}
}
