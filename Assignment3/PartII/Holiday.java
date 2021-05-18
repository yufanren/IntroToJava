
public class Holiday {
	private String name;
	private int day;
	private String month;

	//a.
	public Holiday(String name, int day, String month) {
		this.name = name;
		this.day = day;
		this.month = month;
	}

	//b.
	public static boolean inSameMonth(Holiday h1, Holiday h2) {
		return h1.month.equals(h2.month);
	}

	//c.
	public static double avgDate(Holiday[] holidays) {
		double totalDay = 0;
		for (Holiday currentDay : holidays)
			totalDay += (double) currentDay.day;
		return totalDay / holidays.length;
	}

	//d.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	//e.
	public String toString() {
		return name + ": " + month + " " + String.valueOf(day);
	}
	
	public static void main(String[] args) {
		//f.
		Holiday independenceDay = new Holiday("Independence Day", 4, "July");
		
		Holiday[] holidays = new Holiday[5];
		holidays[0] = new Holiday("May Day", 1, "May");
		holidays[1] = new Holiday("Spagetti Day", 15, "May");
		holidays[2] = new Holiday("Groundhog Day", 7, "February");
		holidays[3] = new Holiday("Dance Manic Day", 6, "June");
		holidays[4] = new Holiday("The End Day", 12, "December");

		System.out.println("Is May day and Spagetti Day in the same month: " +
						(inSameMonth(holidays[0], holidays[1])));
		System.out.println("Is May day and Groundhog Day in the same month: " +
						(inSameMonth(holidays[0], holidays[2])));
		System.out.println("The average day on the holiday list is " + avgDate(holidays));
		System.out.println(independenceDay.toString());
	}
}
