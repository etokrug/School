public class Dealer
{
	Deck dealerDeck;
	
	
	Dealer() {
		this.dealerDeck = new Deck();
	}
	
	public void layOutDeck(int cardsPerLine) {
		dealerDeck.PrintDeck(cardsPerLine);
	}
	
	public void dealerShuffle() {
		dealerDeck.Shuffle();
	}
	public void deal(int cardsPerLine, int hands) {
		
	}
	
}
