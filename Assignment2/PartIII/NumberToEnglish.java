import java.util.Scanner;

public class NumberToEnglish {

	public static String numberToEnglish(int num) {

		String result = "";
		if (num == 0) return "zero";
		if (num < 0) {
			result += "negative ";
			num *= -1;
		}
		int million = num / 1000000;
		int millionReminder = num % 1000000;
		if (million > 0) {
			result += numberToEnglish(million) + " million ";
		}
		int thousand = millionReminder / 1000;
		int thousandReminder = millionReminder % 1000;
		if (thousand > 0) {
			result += numberToEnglish(thousand) + " thousand ";
		}
		int hundred = thousandReminder / 100;
		int hundredReminder = thousandReminder % 100;
		if (hundred > 0) {
			result += getSingleDigit(hundred) + " hundred ";
		}
		if (hundredReminder > 0) {
			if (hundredReminder >= 20) {
				int tenthDigit = hundredReminder / 10;
				result += getTenthDigit(tenthDigit) + " ";
				hundredReminder %= 10;
			}
			else if (hundredReminder >= 10) {
				result += getTeens(hundredReminder);
				hundredReminder = 0;
			}
			if (hundredReminder > 0)
				result += getSingleDigit(hundredReminder);
		}
		return result;
	}

	public static String getTenthDigit(int num) {
		String tenth;
		switch (num) {
			case 2:
				tenth = "twenty";
				break;
			case 3:
				tenth = "thirty";
				break;
			case 4:
				tenth = "forty";
				break;
			case 5:
				tenth = "fifty";
				break;
			case 6:
				tenth = "sixty";
				break;
			case 7:
				tenth = "seventy";
				break;
			case 8:
				tenth = "eighty";
				break;
			case 9:
				tenth = "ninety";
				break;
			default:
				tenth = "";
		}
		return tenth;
	}

	public static String getTeens(int num) {
		String teen;
		switch (num) {
			case 10:
				teen = "ten";
				break;
			case 11:
				teen = "eleven";
				break;
			case 12:
				teen = "twelve";
				break;
			case 13:
				teen = "thirteen";
				break;
			case 14:
				teen = "fourteen";
				break;
			case 15:
				teen = "fifteen";
				break;
			case 16:
				teen = "sixteen";
				break;
			case 17:
				teen = "seventeen";
				break;
			case 18:
				teen = "eighteen";
				break;
			case 19:
				teen = "nineteen";
				break;
			default:
				teen = "";
		}
		return teen;
	}

	public static String getSingleDigit(int num) {
		String digit;
		switch (num) {
			case 1:
				digit = "one";
				break;
			case 2:
				digit = "two";
				break;
			case 3:
				digit = "three";
				break;
			case 4:
				digit = "four";
				break;
			case 5:
				digit = "five";
				break;
			case 6:
				digit = "six";
				break;
			case 7:
				digit = "seven";
				break;
			case 8:
				digit = "eight";
				break;
			case 9:
				digit = "nine";
				break;
			default:
				digit = "";
		}
		return digit;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: " );
		
		int number = in.nextInt();
		
		System.out.println("The number " + number + " in English is " + NumberToEnglish.numberToEnglish(number));
	
	}
}
