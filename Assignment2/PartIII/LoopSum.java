import java.util.Scanner;

public class LoopSum {

	public static int sum100() {
		int result = 0;
		for (int i = 1; i <= 100; i++)
			result += i;
		return result;
	}
	
	public static int sumN(int num) {
		int result = 0;
		for (int i = 1; i <= num; i++)
			result += i;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input natural number N: ");
		int N = in.nextInt();

		if (N < 1) {
			System.out.println("Invalid input, N must be a natural number.");
			return;
		}
		System.out.println("The sum of integers 1 through 100 is: " + sum100());
		System.out.println("The sum of integers 1 through " + N + " is: " + sumN(N));
	}
}
