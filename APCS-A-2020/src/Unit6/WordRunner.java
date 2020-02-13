package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class WordRunner
{
	public static void main ( String[] args )
	{
		//add test cases		
		/*Hello
		World
		JukeBox
		TCEA
		UIL*/
		System.out.println(new Word("Hello").toString());
		System.out.println(new Word("World").toString());
		System.out.println(new Word("JukeBox").toString());
		System.out.println(new Word("TCEA").toString());
		System.out.println(new Word("UIL").toString());

	}
}