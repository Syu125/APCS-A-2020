package Unit6;
import Unit6.TriangleOne;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class TriangleOneRunner
{
	public static void main ( String[] args )
	{
		//add test cases	
		/*hippo
		abcd
		it
		a
		chicken*/
		
		new TriangleOne("hippo").print();
		new TriangleOne("abcd").print();
		new TriangleOne("it").print();
		new TriangleOne("a").print();
		new TriangleOne("chicken").print();
	}
}