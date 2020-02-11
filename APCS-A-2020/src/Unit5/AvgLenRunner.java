package Unit5;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class AvgLenRunner
{
	public static void main( String args[] )
	{
		
		System.out.println( AvgLen.go( "dog", "cats" )) ;
		System.out.println(	AvgLen.go( "aplus", "pigs" ) ) ;
		System.out.println( AvgLen.go( "catgiraffe", "apluscompsci" ) ) ;
		System.out.println( AvgLen.go( "ap", "aplus" ) ) ;
		System.out.println( AvgLen.go( "pluscat", "dogsaplus" ) ) ;
		System.out.println( AvgLen.go( "#", "#" ) ) ;
		System.out.println( AvgLen.go( "aplusdog#13337#", "pigaplusprogram" ) ) ;
		System.out.println( AvgLen.go( "code", "code1234" ) ) ;
		System.out.println( AvgLen.go( "wow", "eplus" ) ) ;
		System.out.println( AvgLen.go( "catsand" , "aplusdogsaplus" ) ) ;
		System.out.println( AvgLen.go( "7", "77777" ) ) ;
		
	}
}