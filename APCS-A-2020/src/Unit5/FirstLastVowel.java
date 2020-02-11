package Unit5;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public static String go( String a )
	{
	   char [] vowels = {'a','e','i','o','u','A','E','I','O','U'};
	   for (char c : vowels) {
		if(a.charAt(0) == c || a.charAt(a.length()-1) == c)
			return "yes";
	}
		return "no";
	}
}