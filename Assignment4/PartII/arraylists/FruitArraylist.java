package arraylists;
import java.util.ArrayList;
import java.lang.Math;

import fruit.*;

public class FruitArraylist {

	public static void main(String[] args) {
		
		// this ArrayList MUST be parameterized
		//2a
		ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();
		fruitArrayList.add(new Apple("sweet", "crisp", "red", false));
		fruitArrayList.add(new Apple("tart", "soft", "green", true));
		fruitArrayList.add(new Apple("tart", "soft", "green", true));
		fruitArrayList.add(new Lemon((int) (Math.random() * 100) + 1, "damp",false));
		fruitArrayList.add(new Lemon((int) (Math.random() * 100) + 1, "enigmatic",false));
		fruitArrayList.add(new Lemon((int) (Math.random() * 100) + 1, "bewildering",false));
		fruitArrayList.add(new Orange("mandarin", "sweet", true));
		fruitArrayList.add(new Orange("mandarin", "sweet", true));
		//2b
		int totalSourness = 0;
		int lemonCount = 0;
		for (Fruit f : fruitArrayList) {
			if (f instanceof Lemon) {
				totalSourness += ((Lemon) f).getSourness();
				lemonCount++;
			}
		}
		System.out.println("The average sourness of all lemons is " + (double) totalSourness / lemonCount);
		//2c
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		Apple rottenGreenApple1;
		rottenGreenApple1 = (Apple) fruitArrayList.get(1);
		for (int i = 0; i < fruitArrayList.size(); i++) {
			Fruit fruit = fruitArrayList.get(i);
			if (fruit.equals(rottenGreenApple1)) {
				System.out.println("Fruit at index " + i + " is equal to the first rotten green Apple object.");
			}
			if (fruit == rottenGreenApple1)
				System.out.println("Fruit at index " + i + " is the same object as the first rotten green Apple object.");
		}
		//remove all rotten green apple from list
		while (fruitArrayList.remove(rottenGreenApple1)) {}
		//2d
		for (Fruit f : fruitArrayList)
			System.out.println(f.toString());
	}
}
