import java.util.Scanner;

public class MuayThai {

	public static int getMinWeight(int weight) {

		if (weight >= 220) return 220;
		else if (weight >= 190) return 190;
		else if (weight >= 183) return 183;
		else if (weight >= 175) return 175;
		else if (weight >= 167) return 167;
		else if (weight >= 160) return 160;
		else if (weight >= 154) return 154;
		else if (weight >= 147) return 147;
		else if (weight >= 140) return 140;
		else if (weight >= 135) return 135;
		else if (weight >= 130) return 130;
		else if (weight >= 126) return 126;
		else if (weight >= 122) return 122;
		else if (weight >= 118) return 118;
		else if (weight >= 115) return 115;
		else if (weight >= 112) return 112;
		else if (weight >= 0) return 0;
		else return -1;
	}
	
	public static String getWeightClass(int weight) {
		
		String weightClass = null;

		switch (weight) {
			case 220:
				weightClass = "Super heavyweight";
				break;
			case 190:
				weightClass = "Heavyweight";
				break;
			case 183:
				weightClass = "Cruiserweight";
				break;
			case 175:
				weightClass = "Super light heavyweight";
				break;
			case 167:
				weightClass = "Light heavyweight";
				break;
			case 160:
				weightClass = "Super middleweight";
				break;
			case 154:
				weightClass = "Middleweight";
				break;
			case 147:
				weightClass = "Super welterweight";
				break;
			case 140:
				weightClass = "Welterweight";
				break;
			case 135:
				weightClass = "Super lightweight";
				break;
			case 130:
				weightClass = "Lightweight";
				break;
			case 126:
				weightClass = "Super featherweight";
				break;
			case 122:
				weightClass = "Featherweight";
				break;
			case 118:
				weightClass = "Super bantamweight";
				break;
			case 115:
				weightClass = "Bantamweight";
				break;
			case 112:
				weightClass = "Super flyweight";
				break;
			case 0:
				weightClass = "Flyweight";
				break;
		}
		// use a switch statement to assign the correct
		// value to weightClass and return the result
		
		return weightClass;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input weight in pounds: ");
		int pounds = in.nextInt();
		String weightClass = getWeightClass(getMinWeight(pounds));

		if (weightClass != null)
		// if pounds is greater than zero
		System.out.println("Weight class for " + pounds + " is " + weightClass);
		
		// if for some reason you put in a negative number of pounds:
		else
		System.out.println("Invalid weight value");
	}
}
