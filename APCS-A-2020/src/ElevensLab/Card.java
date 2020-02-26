package ElevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	//instance variables
		//String suit
		//int face
	private String suit;
	private String rank;
	private int face;

  	//constructors
	public Card() {
		suit = "Spades";
		face = 9;
	}
	public Card(String rank, String suit, int face) {
		this.rank = rank;
		this.suit = suit;
		this.face = face;
	}

	// modifiers
		//set methods
	public void setRank(String rank) {
		this.rank = rank;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public void setFace(int face) {
		this.face = face;
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
		return face;
	}

  	//toString
	public String toString() {
		return "";
	}
 }