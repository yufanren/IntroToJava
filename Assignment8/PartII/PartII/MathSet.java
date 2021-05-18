package PartII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	public Set<E> intersection(Set<E> s2)
	{
		Set<E> intersection = new HashSet<>();
		for (Iterator<E> i = this.iterator(); i.hasNext();) {
			E temp = i.next();
			if (s2.contains(temp))
				intersection.add(temp);
		}
		return intersection;
	}
	
	public Set<E> union(Set<E> s2)
	{
		Set<E> union = new HashSet<>();
		union.addAll(this);
		union.addAll(s2);
		return union;
	}
	
	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2)
	{
		Set<Pair<E, T>> cartesianProducts = new HashSet<Pair<E, T>>();
		for (Iterator<E> i = this.iterator(); i.hasNext();) {
			E item1 = i.next();
			for (Iterator<T> j = s2.iterator(); j.hasNext();) {
				T item2 = j.next();
				cartesianProducts.add(new Pair<E, T>(item1, item2));
			}
		}
		return cartesianProducts;
	}
	
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		MathSet<Integer> s1 = new MathSet<>();
		s1.add(3);
		s1.add(6);
		s1.add(9);
		MathSet<Integer> s2 = new MathSet<>();
		s2.add(3);
		s2.add(4);
		s2.add(7);
		System.out.println("Union of s1 and s2 is " + s1.union(s2));
		System.out.println("Intersection of s1 and s2 is " + s1.intersection(s2));

		MathSet<String> s3 = new MathSet<>();
		s3.add("Tic");
		s3.add("Tac");
		s3.add("Toe");
		System.out.println("Cartisian product of s1 and s3 is " + s1.cartesianProduct(s3));

		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
	}
}
