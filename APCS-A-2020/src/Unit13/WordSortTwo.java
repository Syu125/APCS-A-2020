package Unit13;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo {
	private String[] wordRay;
	private ArrayList<String> orig;
	private ArrayList<String> ordered;

	public WordSortTwo(String sentence) {
		wordRay = sentence.split(" ");
	}

	public void sort() {
		ordered = new ArrayList<String>();
		orig = new ArrayList<String>();
		for (String string : wordRay) {
			orig.add(string);
		}
		while (orig.size() > 0) {
			String s = orig.get(0);

			for (int i = 0; i < orig.size(); i++) {
				if (s.charAt(0) > orig.get(i).charAt(0)) {
					s = orig.get(i);
				} else if (s.length() > 1 && orig.get(i).length() > 1) {
					if (s.charAt(0) == orig.get(i).charAt(0) && s.charAt(1) > orig.get(i).charAt(1)) {
						s = orig.get(i);
					}
					
				}
			}
			ordered.add(s);
			orig.remove(s);
			orig.trimToSize();
		}

	}

	public String toString() {
		String output = "";
		for (String string : ordered) {
			output += string + "\n";
		}
		return output;
	}
}