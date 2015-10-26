import java.util.List;
import java.util.ArrayList;

public class Dealer
{
	private Deck dealerDeck;
	private List<Hand> hands;
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
	
	private void dealerShuffle(int times) {
		dealerDeck.Shuffle(times);
	}
	
	private int deal(int handsToDeal, int cardsPerHand, int deckIndex) {
		this.hands = new ArrayList<Hand>();
		
		for (int i = 0; i < handsToDeal; i++) {
			Hand handToAdd = new Hand();
			hands.add(handToAdd);
		}

		int handCount = 0;
		int stopper = (cardsPerHand * handsToDeal) + deckIndex;
		for (int i = deckIndex; i < stopper; i++, deckIndex++) {

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
		return deckIndex;
	}
	
	public void PlayGames() {
		int deckIndex = 0;
		try {
			if (cardsPerHand * handsToDeal * games > dealerDeck.DeckLength()) 
				throw new IllegalArgumentException("Error: Number of hands by number of games and number of cards per hand exceeds the amount of cards in the deck.");
			
			if (shuffle) dealerShuffle(3);
			System.out.printf("Deck: ");
			layOutDeck(cardsPerLine);
			
			for (int i = 0; i < games; i++){
				System.out.printf("\n=== Game %d ===\n", i + 1);
				deckIndex = deal(handsToDeal, cardsPerHand, deckIndex);
				
				for (int internal = 0; internal < handsToDeal; internal++) {
					System.out.printf("\n--- Hand %d ---\n", internal + 1);
					hands.get(internal).PrintHand(cardsPerLine);
					System.out.println();
				}
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.printf("\n=== Games Complete ===\n");
		
		
	}
	
}
