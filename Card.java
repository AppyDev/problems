package codingProblems;

public class Card {
	public enum Suit {
		CLUBS (1), SPADES (2), HEARTS (3), DIAMONDS (4);
		int value;
		private Suit(int v) { value = v; }
	};

	private int card;
	private Suit suit;

	public Card(int r, Suit s) {
		card = r;
		suit = s;
	}

	public int getValue() { return card; }
	public Suit getSuit() { return suit; }
}

