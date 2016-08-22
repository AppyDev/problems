package codingProblems;
import java.util.Scanner;

public class BlackJackCard extends Card {
	public BlackJackCard(int r, Suit s) { super(r, s); }

	public int value() {
		int r = super.getValue();
		if (r == 1) return 11; // aces are 11
		if (r < 10) return r;
		return 10;
	}

	boolean isAce() {
		return super.getValue() == 1;
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		BlackJackCard b=new BlackJackCard(1, Suit.CLUBS);
		BlackJackCard c=new BlackJackCard(9, Suit.SPADES);
		System.out.println(b.value());
		System.out.println(c.value());
		System.out.println(b.getSuit());
		System.out.println(c.getSuit());
		in.close();	
	}
}
