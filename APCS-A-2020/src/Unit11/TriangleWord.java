package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWord
{
	//instance variables and constructors could be present, but are not necessary
		
	public static void printTriangle(String word)
	{
		String s = "";
		for(int i = 0; i < word.length(); i++) {
			s += word.charAt(i);
			for (int j = 0; j <= i; j++) {
				System.out.print(s);
			}
			System.out.println();
		}
	}
}