package Unit4;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;
import Unit4.NumberVerify;
public class NumberVerifyRunner
{
	public static void main ( String[] args )
	{
		//add in input
		Scanner s = new Scanner(in);
		out.print("Enter a whole number :: ");
		int i = s.nextInt();
		System.out.println(i + " is odd :: " + NumberVerify.isOdd(i));
		System.out.println(i + " is even :: " + NumberVerify.isEven(i) + "\n");
		
		//add in more test cases
		/*111
		2000
		-99
		1111
		-850*/
		
		System.out.println("More test cases...\n");
		NumberVerify test1 = new NumberVerify(111);
		NumberVerify test2 = new NumberVerify(2000);
		NumberVerify test3 = new NumberVerify(-99);
		NumberVerify test4 = new NumberVerify(1111);
		NumberVerify test5 = new NumberVerify(-850);
	}
}