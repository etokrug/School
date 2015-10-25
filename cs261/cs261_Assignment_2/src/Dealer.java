import java.util.List;
import java.util.ArrayList;

public class Dealer
{
	private Deck dealerDeck;
	private List<Hand> hands = new ArrayList<Hand>();
	private int games = 0;
	private int handsToDeal = 0;
	private int cardsPerHand = 0;
	private int cardsPerLine = 0;
	private boolean shuffle = false;
	
	Dealer(int games, int handsToDeal, int cardsPerHand, int cardsPerLine, boolean shuffle) {
		this.dealerDeck = new Deck();
		this.games = games;
		this.handsToDeal = handsToDeal;
		this.cardsPerHand = cardsPerHand;
		this.cardsPerLine = cardsPerLine;
		this.shuffle = shuffle;
	}
	
	Dealer() {
		this.dealerDeck = new Deck();
	}
	
	private void layOutDeck(int cardsPerLine) {
		dealerDeck.PrintDeck(cardsPerLine);
	}
	
	private void dealerShuffle() {
		dealerDeck.Shuffle();
	}
	private void deal(int handsToDeal, int cardsPerHand) {
		// TODO: Add try/catch here for nullpointer if there are
		// more cards than can be presented
		try {
			if (cardsPerHand * handsToDeal > 52) {
				throw new IllegalArgumentException("The number of hands to deal exceeds the amount of cards to be dealt per hand.");
			}
			for (int i = 0; i < handsToDeal; i++) {
				hands.add(new Hand());
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void PlayGames() {
		if (shuffle) dealerShuffle();
		layOutDeck(cardsPerLine);
		deal(handsToDeal, cardsPerHand);
		
	}
	
}
