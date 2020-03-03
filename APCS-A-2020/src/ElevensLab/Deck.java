package ElevensLab;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//make a Deck class
public class Deck {
	public static final int NUMCARDS = 52;
	public static String[] SUITS = "CLUBS HEARTS DIAMONDS SPADES".split(" ");

	private List<Card> cards;
	private int top;
private ArrayList <Card> temp;
	// make a Deck constructor
	public Deck(String[] ranks, String[] suits, int[] points) {
		// refer cards to new ArrayList
		cards = new ArrayList<Card>();
		// set top to the top of the deck 51
		top = 51;
		// loop through all suits
		for (int i = 0; i < suits.length; i++) {
			// loop through all faces 1 to 13
			for (int j = 0; j < points.length; j++) {
				// add a new TwentyOneCard to the deck
				//System.out.println("i: " + i + "   j: " + j);
				//System.out.println(ranks[j] + " of " + suits[i] + " (point value = " + points[j] + ")");

				cards.add(new Card(ranks[j], suits[i], points[j]));
			}
		}
		temp = new ArrayList <Card>();
		for(int i = 0; i < cards.size(); i++) {
			temp.add(cards.get(i));
		}
		//temp = (ArrayList<Card>) cards;
		
	}
	// make a dealCard() method that returns the top card

	// isEmpty
	public boolean isEmpty() {
		if (cards.size() > 0) {
			return false;
		}
		return true;
	}

	// size: returns the number of cards in the deck that are left to be dealt
	public int size() {
		return cards.size();
	}

	// deal: removes a card and returns it
	public Card deal() {
		if(!isEmpty()) {
			Card c = temp.get(temp.size()-1);
			temp.remove(c);

			return c;
			
		}else
			return null;
		

	}

	// write a shuffle() method
	public void Shuffle() {
		//Deck Tester
		/*int ran = 0;
		for (int i = cards.size()-1; i >= 0; i --) {
			ran = (int) (Math.random() * (i +1));
			Card temp = cards.get(ran);
			cards.set(ran,cards.get(i)) ;
			cards.set(i, temp);
		}*/
		//Deck Runner
		Collections.shuffle(cards);
		temp = new ArrayList <Card>();
		for(int i = 0; i < cards.size(); i++) {
			temp.add(cards.get(i));
		}
	}
	
	// reset the top card
	public String toString() {
		String send = "";
		for(Card c : cards) {
			send += c.toString() + "\n";
		}
		return send;
	}
}