public class Card
{
	public enum Rank
	{
		ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT,
		SEVEN, SIX, FIVE, FOUR, THREE, DEUCE
	}
	
	public enum Suit
	{
		 HEARTS, DIAMONDS, CLUBS, SPADES
	}
	
	private final Rank	rank;
	private final Suit	suit;
	
	Card(Rank rank, Suit suit)
	{
	    this.rank = rank;
	    this.suit = suit;
	}
	
	public Rank rank()          { return rank; }
	public Suit suit()          { return suit; }
	public String toString()    { return rank + " of " + suit; }
}
