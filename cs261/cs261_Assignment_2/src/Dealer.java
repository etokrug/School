import java.util.List;
import java.util.ArrayList;

public class Dealer
{
	// This class handled the majority of the leg work for the program
	private Deck dealerDeck;
	private List<Hand> hands;
	private int games = 0;
	private int handsToDeal = 0;
	private int cardsPerHand = 0;
	private int cardsPerLine = 0;
	private boolean shuffle = false;
	
	// Constructor which sets initializes all relevant information taken from the initial command line in main
	Dealer(int games, int handsToDeal, int cardsPerHand, int cardsPerLine, boolean shuffle) {
		this.dealerDeck = new Deck();
		this.games = games;
		this.handsToDeal = handsToDeal;
		this.cardsPerHand = cardsPerHand;
		this.cardsPerLine = cardsPerLine;
		this.shuffle = shuffle;
	}
	
	// Default constructor. Created for testing as there are no getters/setters
	Dealer() {
		this.dealerDeck = new Deck();
	}
	
	// Dealer's action to print the deck
	private void layOutDeck(int cardsPerLine) {
		dealerDeck.PrintDeck(cardsPerLine);
		System.out.printf("\n");
	}
	
	// Dealer's action to shuffle the deck
	private void dealerShuffle(int times) {
		dealerDeck.Shuffle(times);
	}
	
	// Dealer's action to deal cards into hands
	private int deal(int handsToDeal, int cardsPerHand, int deckIndex) {
		// This is initialized/reinitialized every time this is called
		// in order to clear out the list at the beginning of each game.
		this.hands = new ArrayList<Hand>();
		
		// Initialize the hands
		for (int i = 0; i < handsToDeal; i++) {
			Hand handToAdd = new Hand();
			hands.add(handToAdd);
		}

		int handCount = 0;
		// Stopper takes the deckIndex passed to it which is used to 
		// represent the dealer not losing his place in the deck when dealing.
		int stopper = (cardsPerHand * handsToDeal) + deckIndex;
		// This is broken apart so that each hand gets one card then the dealer
		// moves on to the next hand.
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
	
	// PlayGames is the initializer for the action of this program.
	// The dealer, as in real life, should handle the majority of the work in the game.
	public void PlayGames() {
		int deckIndex = 0;
		// This block throws an exception if the number of cards in the deck is exceeded by (number of hands * number of cards to deal * games)
		// This is important because, as in real life, a dealer would not be able to deal to an overcrowded game.
		try {
			if (cardsPerHand * handsToDeal * games > dealerDeck.DeckLength()) 
				throw new IllegalArgumentException("Error: Number of hands by number of games and number of cards per hand exceeds the amount of cards in the deck.");
			
			if (shuffle) dealerShuffle(3);
			System.out.printf("Deck: ");
			layOutDeck(cardsPerLine);
			
			// Special print statement, think of it as the dealer speaking his mind.
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
