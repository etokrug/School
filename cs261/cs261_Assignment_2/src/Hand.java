import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Hand
{
	// Private ArrayList which holds all of the cards passed to it by the dealer
	private List<Card> hand = new ArrayList<Card>();
	
	// Add method created to reduce access
	public void AddCard(Card cardToAdd) {
		hand.add(cardToAdd);
	}
	
	// Print method which prints out a cards specific information, called by the dealer
    public void PrintHand(int cardsPerLine) {
    	int newLine = 0;
    	Card printCard;
    	for (Iterator<Card> cardIter = hand.iterator(); cardIter.hasNext();) {
    		int newLineModulo = newLine++ % (cardsPerLine);
    		if (newLineModulo == 0) {
    			System.out.printf("\n");
    		}
    		printCard = cardIter.next();
    		System.out.printf("%s(%d)%s", printCard.toString(), printCard.cardScore(), (cardIter.hasNext() ? ", ": ""));
    	}
    	System.out.printf("\nScore: %d", GetScore());
    }
    
    // Return the total score of the hand.
    public int GetScore() {
    	int returnScore = 0;
    	for (Iterator<Card> cardIter = hand.iterator(); cardIter.hasNext();) {
    		returnScore += cardIter.next().cardScore();
    	}
    	return returnScore;
    }
}
