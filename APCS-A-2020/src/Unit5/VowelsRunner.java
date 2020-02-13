package Unit5;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class VowelsRunner
{
	public static void main( String args[] )
	{
		FirstLastVowel s = new FirstLastVowel();
		
		//given structure needed to be accessed in a static way, 
		//so I changed "s.go" to "FirstLastVowel.go"
		/*dog#cat#pigaplus
		pigs#apluscompsci#food
		##catgiraffeapluscompscI
		apluscatsanddogsaplus###
		###
		Aplusdog#13337#pigaplusprogram
		code#H00P#code1234
		##wowgira77##eplus
		catsandaplusdogsaplus###
		7
		A
		E
		9AEIOUaeiou@*/
		
		System.out.println(  FirstLastVowel.go(  "dog#cat#pigaplus")    );
		System.out.println(  FirstLastVowel.go(  "pigs#apluscompsci#food")    );
		System.out.println(  FirstLastVowel.go(  "##catgiraffeapluscompsci")    );
		System.out.println(  FirstLastVowel.go(  "apluscatsanddogsaplus###")    );
		System.out.println(  FirstLastVowel.go(  "##")    );
		System.out.println(  FirstLastVowel.go(  "aplusdog#13337#pigaplusprogram")    );
		System.out.println(  FirstLastVowel.go(  "code#H00P#code1234")    );
		System.out.println(  FirstLastVowel.go(  "##wowgira77##eplus")    );
		System.out.println(  FirstLastVowel.go(  "catsandaplusdogsaplus###")    );
		System.out.println(  FirstLastVowel.go(  "7")    );
		System.out.println(  FirstLastVowel.go(  "A")    );
		System.out.println(  FirstLastVowel.go(  "E")    );
		System.out.println(  FirstLastVowel.go(  "9AEIOUaeiou@")    );

	}
}



