
public class WindChill {

	public static double windChill(double temp, double windSpeed) {

		return 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
	}
	
	public static void main(String[] args) {

		double temp = Double.parseDouble(args[0]);
		double windSpeed = Double.parseDouble(args[1]);

		// if the wind chill is valid:
		if (!(temp > 50.0 || temp < -50.0 || windSpeed > 110.0 || windSpeed < 3.0)) {
			double windChillTemp = windChill(temp, windSpeed);
			System.out.println("For a temperature of " + temp +
							" with wind speed of " + windSpeed +
							", the wind chill is " + windChillTemp);
		}
		// if the wind chill is not valid:
		else System.out.println("Cannot calculate a valid wind chill for this temperate and/or wind speed");
	}
}
