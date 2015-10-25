import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

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
		System.out.printf("\n");
	}
	
	private void dealerShuffle() {
		dealerDeck.Shuffle();
	}
	
	private void deal(int handsToDeal, int cardsPerHand) {
		for (int i = 0; i < handsToDeal; i++) {
			Hand handToAdd = new Hand();
			hands.add(handToAdd);
		}

		int handCount = 0;
		for (int i = 0; i < cardsPerHand * handsToDeal; i++) {

			Card cardToDeal = dealerDeck.GetCard(i);
			Hand handToAddTo = hands.get(handCount);
			handToAddTo.AddCard(cardToDeal);
			hands.set(handCount, handToAddTo);
			
			if (handCount == handsToDeal - 1) {
				handCount = 0;
			}
			else {
				handCount++;
			}
		}
	}
	
	public void PlayGames() {
		try {
			if (cardsPerHand * handsToDeal * games > dealerDeck.DeckLength()) 
				throw new IllegalArgumentException("Number of hands by number of games and number of cards per hand exceeds the amount of cards in the deck.");
			if (shuffle) dealerShuffle();
			System.out.println("Deck: ");
			layOutDeck(cardsPerLine);
			deal(handsToDeal, cardsPerHand);
			for (int i = 0; i < hands.size(); i++) {
				System.out.printf("\n\n--- Hand %d ---\n", i + 1);
				hands.get(i).PrintHand(cardsPerLine);
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.printf("\n\n=== Games Complete ===\n");
		
		
	}
	
}
