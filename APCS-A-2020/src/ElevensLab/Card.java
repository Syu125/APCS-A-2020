package ElevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Card
{
	public static final String pointS[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"}; //anything above 10 is treated as having 10 points, points based on index

	//instance variables
		//String suit
		//int point
	private String suit;
	private String rank;
	private int point;

  	//constructors
	public Card() {
		suit = "Spades";
		point = 1;
	}
	public Card(String rank, String suit, int point) {
		this.rank = pointS[point];		
		this.suit = suit;
		this.point = point;
	}
	public Card(String suit, int point) {
		this.suit = suit;
		this.rank = pointS[point];
		this.point = point;
	}

	// modifiers
		//set methods
	public void setRank(String rank) {
		this.rank = rank;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public void setPoint(int point) {
		this.point = point;
	}

  	//accessors
		//get methods
	public String getRank() {
		return rank;
	}
	public String getSuit() {
		return suit;
	}
	public int getPoint() {
		return point;
	}

  	//toString
	public String toString() {
		return rank + " of " + suit + " (point value = " + point + ")";
	}
 }