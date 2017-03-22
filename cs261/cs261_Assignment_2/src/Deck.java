import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;


public class Deck
{
    private static final List<Card> deck = new ArrayList<Card>();
    
    // Default constructor for the deck
    Deck() {
    	for (Card.Suit suit : Card.Suit.values()) {
    		for (Card.Rank rank : Card.Rank.values()) {
    			deck.add(new Card(rank, suit));
    		}
    	}
    }
    
    // Prints the deck the specific way a deck would be laid out. This action is called by the Dealer
    public void PrintDeck(int cardsPerLine) {
    	int newLine = 0;
    	Card printCard;
    	// Iterate over our ArrayList to print the information line by line.
    	for (Iterator<Card> cardIter = deck.iterator(); cardIter.hasNext();) {
    		int newLineModulo = newLine++ % (cardsPerLine);
    		if (newLineModulo == 0) {
    			System.out.printf("\n");
    		}
    		printCard = cardIter.next();
    		// Ternary operator kicks in when .hasNext() returns false so that it doesn't print a comma
    		System.out.printf("%s(%d)%s", printCard.toString(), printCard.cardScore(), (cardIter.hasNext() ? ", ": ""));
    	}
    }
    
    public void Shuffle(int times) {
    	// Deck is shuffled recursively to further vary the deck.
    	int deckSize = deck.size();
    	for (int i = 0; i < deckSize; i++) {
    		int cardSwapFrom = 0;
    		int cardSwapTo = 0;
    		// If the two random integers are equal then run it again, we don't want the card going to the same place.
	    	while (cardSwapFrom == cardSwapTo) {
		    	cardSwapFrom = ThreadLocalRandom.current().nextInt(0, deckSize);
		    	cardSwapTo = ThreadLocalRandom.current().nextInt(0, deckSize);
	    	}
	    	
	    	// Empty cards to hold moving card objects
	    	Card cardSwapFromHolder;
	    	Card cardSwapToHolder;
	    	
	    	// Swapping action, takes the the two random integers and gets them into the holder card objects
	    	cardSwapFromHolder = deck.get(cardSwapFrom);
	    	cardSwapToHolder = deck.get(cardSwapTo);
	    	
	    	// Reset the card objects into their new spaces in the ArrayList
	    	deck.set(cardSwapFrom, cardSwapToHolder);
	    	deck.set(cardSwapTo, cardSwapFromHolder);
    	}
    	// If times is greater than 0, recursively run the shuffling
    	if (times > 0){
    		Shuffle(--times);
    	}
    }
    
    // Get a card from the deck based on an index.
    // Created to further reduce access to the deck.
    public Card GetCard(int index) {
    	return deck.get(index);
    }
    
    // Get the deck length
    public int DeckLength() {
    	return deck.size();
    }
}
