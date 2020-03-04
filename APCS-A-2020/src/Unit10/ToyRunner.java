package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class ToyRunner
{
	public static void main(String[] args)
	{
		//test cases
		/*
		 * sorry
		 * gi joe
		 */
		Toy t1 = new Toy("sorry");
		Toy t2 = new Toy("gi joe");
		t1.setCount(1);
		t2.setCount(5);
		System.out.println(t1);
		System.out.println(t2);
	}
}