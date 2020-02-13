package Unit5;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		//add test cases
		/*hello goodbye
		one two
		three four
		TCEA UIL
		State Champions
		ABC ABC
		ABC CBA
		Same Same*/
		
		System.out.println(new StringEquality("hello", "goodbye").toString());
		System.out.println(new StringEquality("one", "two").toString());
		System.out.println(new StringEquality("three", "four").toString());
		System.out.println(new StringEquality("TCEA", "UIL").toString());
		System.out.println(new StringEquality("State", "Champions").toString());
		System.out.println(new StringEquality("ABC", "ABC").toString());
		System.out.println(new StringEquality("ABC", "CBA").toString());
		System.out.println(new StringEquality("Same", "Same").toString());

	}
}