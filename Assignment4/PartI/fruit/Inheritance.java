package fruit;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects
		Fruit f1 = new Fruit();
		Fruit a1 = new Apple("delicious", "saggy", "red", false);
		Fruit c1 = new Citris("nasty", "green", true);
		Orange o1 = new Orange("cheap", "mushy", false);
		Citris l1 = new Lemon(100, "discombobulating", true);

		System.out.println(f1.toString());
		System.out.println(a1.toString());
		System.out.println(c1.toString());
		System.out.println(o1.toString());
		System.out.println(l1.toString());
	}
}
