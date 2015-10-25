import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;


public class Deck
{
    private static final List<Card> deck = new ArrayList<Card>();
    
    Deck() {
    	for (Card.Suit suit : Card.Suit.values()) {
    		for (Card.Rank rank : Card.Rank.values()) {
    			deck.add(new Card(rank, suit));
    		}
    	}
    }
    
    public void PrintDeck(int cardsPerLine) {
    	int newLine = 0;
    	Card printCard;
    	for (Iterator<Card> cardIter = deck.iterator(); cardIter.hasNext();) {
    		int newLineModulo = newLine++ % (cardsPerLine);
    		if (newLineModulo == 0) {
    			System.out.printf("\n");
    		}
    		printCard = cardIter.next();
    		System.out.printf("%s(%d)%s", printCard.toString(), printCard.cardScore(), (cardIter.hasNext() ? ", ": ""));
    	}
    }
    
    public void Shuffle() {
    	for (int i = 0; i < 52; i++) {
    		int cardSwapFrom = 0;
    		int cardSwapTo = 0;
	    	while (cardSwapFrom == cardSwapTo) {
		    	cardSwapFrom = ThreadLocalRandom.current().nextInt(0, 52);
		    	cardSwapTo = ThreadLocalRandom.current().nextInt(0, 52);
	    	}
	    	
	    	Card cardSwapFromHolder;
	    	Card cardSwapToHolder;
	    	
	    	cardSwapFromHolder = deck.get(cardSwapFrom);
	    	cardSwapToHolder = deck.get(cardSwapTo);
	    	
	    	deck.set(cardSwapFrom, cardSwapToHolder);
	    	deck.set(cardSwapTo, cardSwapFromHolder);
    	}
    }
    
    public Card GetCard(int index) {
    	return deck.get(index);
    }
    
    public int DeckLength() {
    	return deck.size();
    }
}
