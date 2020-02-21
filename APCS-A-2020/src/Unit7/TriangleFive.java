package Unit7;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive {
	private char letter;
	private int amount;

	public TriangleFive() {
		letter = 'A';
		amount = 3;
	}

	public TriangleFive(char c, int amt) {
		letter = c;
		amount = amt;
	}

	public void setLetter(char c) {
		letter = c;
	}

	public void setAmount(int amt) {
		amount = amt;
	}

	public String toString() {
		String output = "";
		int total = amount;
		while (amount > 0) {
			for (int i = 0; i < amount; i++) {
				char l = letter;
				l += i;
				if((int)l == 90)
					
				for (int j = 0; j < total - i; j++) {
					output += l;
				}
				output += " ";
			}
			output += "\n";
			amount--;
		}
		return output;
	}
}