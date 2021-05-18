
public class GravityCalculator {

	public static double calculatePosition(double initialPosition, double initialVelocity, double fallingTime) {
		double a = -9.81;
		return 0.5 * a * Math.pow(fallingTime, 2) + initialVelocity * fallingTime + initialPosition;
	}
	
	public static void main(String[] args) {
		//System.out.println(calculatePosition(0, 0, 10));
	}
}
