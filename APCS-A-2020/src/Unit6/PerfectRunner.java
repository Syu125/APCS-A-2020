package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class PerfectRunner
{
	public static void main( String args[] )
	{
		//add test cases
		/*496
		45
		6
		14
		8128
		1245
		33
		28
		27
		33550336*/
		System.out.println(new Perfect(496).toString());
		System.out.println(new Perfect(45).toString());
		System.out.println(new Perfect(6).toString());
		System.out.println(new Perfect(14).toString()) ;
		System.out.println(new Perfect(8128).toString());
		System.out.println(new Perfect(1245).toString());
		System.out.println(new Perfect(33).toString());
		System.out.println(new Perfect(28).toString());
		System.out.println(new Perfect(27).toString());
		System.out.println(new Perfect(33550336).toString());
	}
}