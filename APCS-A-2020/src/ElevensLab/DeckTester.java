package ElevensLab;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 * 
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		// Note: Student solutions will vary. The following is an example.

		String[] ranks = { "jack", "queen", "king" };
		String[] suits = { "blue", "red" };
		int[] pointValues = { 11, 12, 13 };
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Shuffle Full Deck ****");
		String[] rank = { "ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK",
				"QUEEN", "KING" }; // anything above 10 is treated as having 10 points, points based on index
		String[] suit = { "CLUBS", "SPADES", "HEARTS", "DIAMONDS" };
		int[] points = new int[rank.length];
		for (int i = 0; i < rank.length; i++) {
			points[i] = i + 1;
		}
		Deck test = new Deck(rank, suit, points);
		
		System.out.println("  toString:\n" + test.toString());
		test.Shuffle();
		System.out.println("  shuffled: " + test.toString());

	}
}
