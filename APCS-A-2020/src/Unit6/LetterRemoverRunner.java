package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
		//add test cases		
		/*I am Sam I am a
		ssssssssxssssesssssesss s
		qwertyqwertyqwerty a
		abababababa b
		abaababababa x*/	
		System.out.println(new LetterRemover("I am Sam I am", 'a').toString());
		System.out.println(new LetterRemover("ssssssssxssssesssssesss",'s').toString());
		System.out.println(new LetterRemover("qwertyqwertyqwerty", 'a').toString());
		System.out.println(new LetterRemover("abababababa" ,'b').toString());
		System.out.println(new LetterRemover("abaababababa", 'x').toString());

	}
}