public class Card
{
	public enum Rank
	{
		ACE (11), KING (10), QUEEN (10), JACK (10), TEN (10), NINE (9), EIGHT (8),
		SEVEN (7), SIX (6), FIVE (5), FOUR (4), THREE (3), DEUCE (2);
		
		private final int rankScore;
		Rank(int rankScore) {
			this.rankScore = rankScore;
		}
	}
	
	public enum Suit
	{
		HEARTS (4), DIAMONDS (3), CLUBS (2), SPADES (1);
		
		private final int suitScore;
		Suit(int suitScore){
			this.suitScore = suitScore;
		}
	}
	
	private final Rank	rank;
	private final Suit	suit;
	private final int cardScore;
	
	Card(Rank rank, Suit suit)
	{
	    this.rank = rank;
	    this.suit = suit;
	    this.cardScore = rank.rankScore * suit.suitScore;
	}
	
	public Rank rank()          { return rank; }
	public Suit suit()          { return suit; }
	public int cardScore()		{ return cardScore; }
	
	public String toString()    { return rank + " of " + suit; }
}
