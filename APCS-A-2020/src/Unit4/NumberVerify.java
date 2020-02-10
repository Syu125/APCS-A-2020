package Unit4;
//(c) A+ Computer Science

//www.apluscompsci.com

//Name -
//Date -  
//Class -
//Lab  -

import static java.lang.System.*;


public class NumberVerify {
	
	public NumberVerify(int num) {
		System.out.println(num + " is odd :: " +  isOdd(num));
		System.out.println(num + " is even :: " +  isEven(num) + "\n");
	}
	public static boolean isOdd(int num) {
		if (num % 2 == 1 || num % 2 == -1)
			return true;
		return false;
	}

	public static boolean isEven(int num) {
		if (num % 2 == 0)
			return true;
		return false;
	}
}