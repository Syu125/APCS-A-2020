package Unit5;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
		//add test cases
		/*abe ape
		giraffe gorilla
		one two
		fun funny
		123 19
		193 1910
		goofy godfather
		funnel fun*/
	    System.out.println(new WordsCompare("abe", "ape").toString());
	    System.out.println(new WordsCompare("giraffe", "gorilla").toString());
	    System.out.println(new WordsCompare("one", "two").toString());
	    System.out.println(new WordsCompare("fun", "funny").toString());
	    System.out.println(new WordsCompare("123", "19").toString());
	    System.out.println(new WordsCompare("193", "1910").toString());
	    System.out.println(new WordsCompare("goofy", "godfather").toString());
	    System.out.println(new WordsCompare("funnel", "fun").toString());
	}
}