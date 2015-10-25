import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;


public class Deck
{
    private static final List<Card> protoDeck = new ArrayList<Card>();
    
    Deck() {
    	for (Card.Suit suit : Card.Suit.values()) {
    		for (Card.Rank rank : Card.Rank.values()) {
    			protoDeck.add(new Card(rank, suit));
    		}
    	}
    }
    
    public void PrintDeck(int cardsPerLine) {
    	int newLine = 0;
    	Card printCard;
    	for (Iterator<Card> cardIter = protoDeck.iterator(); cardIter.hasNext();) {
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
	    	
	    	cardSwapFromHolder = protoDeck.get(cardSwapFrom);
	    	cardSwapToHolder = protoDeck.get(cardSwapTo);
	    	
	    	protoDeck.set(cardSwapFrom, cardSwapToHolder);
	    	protoDeck.set(cardSwapTo, cardSwapFromHolder);
    	}
    	
    }
}
