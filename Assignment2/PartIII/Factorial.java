
public class Factorial {

	public static long FactorialCal(int num) {

		long result = 1;
		for (int i = 2; i <= num; i++)
			result *= i;
		return result;
	}

	public static void main(String[] args) {
		int val = 20;
		long factorial = FactorialCal(val);
		System.out.println("The factorial of " + val + " is " + factorial);
	}
}
