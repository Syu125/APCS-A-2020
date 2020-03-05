package Unit10;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore {
	private ArrayList<Toy> toyList;
	private ArrayList<Toy> order;

	public ToyStore() {
		toyList = new ArrayList<Toy>();
	}

	public ToyStore(ArrayList<Toy> list) {
		order = new ArrayList<Toy>();
		toyList = list;
		System.out.println(toyList.get(0));
		//order.add(toyList.get(0));
		for (int i = 1; i < toyList.size(); i++) {
			for (Toy t : order) {
				if (!toyList.get(i).getName().equals(t.getName())) {
					order.add(t);
				}
			}
		}
		for (Toy t : order) {
			int count = 0;
			Toy to = new Toy("");
			for (Toy toy : toyList) {
				if (toy.getName().equals(t.getName())) {
					to = toy;
					count++;
				}
			}
			t.setCount(count);
		}
	}

	public void loadToys(String toys) {
		toyList = new ArrayList<Toy>();
		toyList.add(new Toy(toys));
	}

	public Toy getThatToy(String nm) {
		for(Toy t: order) {
			if(t.getName().equals(nm))
				return t;
		}
		return null;
	}

	public String getMostFrequentToy() {

		return "";
	}

	public void sortToysByCount() {
	}

	public String toString() {

		return "";
	}
}