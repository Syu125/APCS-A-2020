package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;
   private String cleaned = "";
   
	public LetterRemover()
	{
		setRemover("test_case", 'c');
		//call set
	}

	//add in second constructor
	public LetterRemover(String s, char rem) {
		sentence = s;
		lookFor = rem;
		
	}
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
			for (int i = 0; i < sentence.length(); i++) {
				if(sentence.charAt(i) != lookFor) {
					cleaned += sentence.charAt(i);
				}
			}
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters() + "\n";
	}
}