package OCP8.functional_interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class ComparatorTest {

	public static void main(String[] args) {
		List<Squirrel> squirrels = new ArrayList<>();
		Squirrel a = new Squirrel("A");
		a.setWeight(15);
		Squirrel b = new Squirrel("B");
		b.setWeight(20);
		Squirrel c = new Squirrel("A");
		c.setWeight(18);
		squirrels.add(a);
		squirrels.add(b);
		squirrels.add(c);

		// write a Comparator that sorts by species name. If two squirrels are from the same species, we want to sort the one
		// that weighs the least first.
//		squirrels.sort(new MultiFieldComparator());
//		System.out.println(squirrels);

		// do the same with the new helper methods of the Comparator interface
		squirrels.sort(new ChainingComparator());
		System.out.println(squirrels);
	}
}

class ChainingComparator implements Comparator<Squirrel> {
	@Override
	// this is the method of the Comparator functional interface we have to implement
	public int compare(Squirrel o1, Squirrel o2) {
		/**
		 * new static helper method:
		 * Accepts a function that extracts a {@link java.lang.Comparable
		 * Comparable} sort key from a type {@code T}, and returns a {@code
		 * Comparator<T>} that compares by that sort key.
		 **/
		Comparator<Squirrel> speciesComparator = Comparator.comparing(s -> s.getSpecies());
		/*
		 * default method:
		 * Returns a lexicographic-order comparator with a function that
		 * extracts a {@code int} sort key.
		 */
		Comparator<Squirrel> joiningComparator = speciesComparator.thenComparingInt(Squirrel::getWeight);
		return joiningComparator.compare(o1, o2);
	}
}

class MultiFieldComparator implements Comparator<Squirrel> {

	@Override
	public int compare(Squirrel o1, Squirrel o2) {
		int result = o1.getSpecies().compareTo(o2.getSpecies());
		if (result != 0) return  result;
		return o1.getWeight() - o2.getWeight();
	}
}

class Squirrel {
	private final String species;
	private int weight;

	Squirrel(String species) {
		requireNonNull(species);
		this.species = species;
	}

	int getWeight() {
		return weight;
	}

	void setWeight(int weight) {
		this.weight = weight;
	}

	String getSpecies() {
		return species;
	}

	@Override
	public String toString() {
		return "Squirrel{" +
				"species='" + species + '\'' +
				", weight=" + weight +
				'}';
	}
}
