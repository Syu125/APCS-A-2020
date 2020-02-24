package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		number = num;

	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int gcf = 0;
		for (int i = 1; i < a; i++) {
			if(a%i == 0 && b%i == 0 && c%i == 0) {
				gcf = i;
			}
		}

		return gcf;
	}

	public void run() {
		for (int i = 1; i < number; i++) {
			for (int j = 1; j < number; j++) {
				for (int k = 1; k < number; k++) {
					if(i < j) {
						if(Math.pow(i, 2)+Math.pow(j, 2) == Math.pow(k, 2)) {
						if(k%2 == 1) {
							if(i%2 == 1 && j%2 == 0) {
								if(greatestCommonFactor(i,j,k) <= 1)
									System.out.println(i + " " + j + " " + k);
							}
							else if(i%2 == 0 && j%2 == 1) {
								if(greatestCommonFactor(i,j,k) <= 1)
									System.out.println(i + " " + j + " " + k);
							}
						}
					}
					}
					
				}
			}
		}
	}
	public String toString()
	{
		String output="";






		return output+"\n";
	}
}