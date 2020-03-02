package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWordRunner
{
	public static void main( String args[] )
	{
		//test cases
		/*a
		it
		box
		toad
		fishy
		dog*/
		
		Scanner s = new Scanner(System.in);
		String word = "";
		boolean run = true;
		while(run) {
			System.out.print("Enter a word :: ");
			word = s.next();
			TriangleWord.printTriangle(word);
			
			System.out.print("\nDo you want to enter more sample input? y/n ");
			if(s.next().contentEquals("y"))
				run = true;
			else
				run = false;
			System.out.println();
		}
	
		
	}
}