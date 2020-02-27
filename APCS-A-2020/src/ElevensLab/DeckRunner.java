package ElevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class DeckRunner
{
	public static void main( String args[] )
	{
		 String [] ranks = {"ZERO","ACE","TWO","THREE","FOUR",
				"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"}; //anything above 10 is treated as having 10 points, points based on index
		 String [] suits = {"CLUBS", "SPADES", "HEARTS", "DIAMONDS"};
		 int [] points = new int [ranks.length];
		 for (int i = 0; i < points.length; i++) {
			points[i] = i; //points[i] = i+1;
			//System.out.println(points[i]);
		 }
		/* System.out.println("ranks length: " + ranks.length);
		 System.out.println("suits length: " + suits.length);
		 System.out.println("points length: " + points.length);*/

		 Deck test = new Deck(ranks, suits, points);
		
		System.out.println( "All cards in order." );
		for( int j = 1; j <= 52; j++ )
		{
			System.out.println( test.deal() );
		}
		
		test.Shuffle();	
		
		System.out.println( "\n\nAll cards after shuffling." );
		for( int j = 1; j <= 52; j++ )
		{
			System.out.println( test.deal() );
		}				
	}
}
