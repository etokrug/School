import java.util.List;
import java.util.ArrayList;

public class Deck
{
    private static final List<Card> protoDeck = new ArrayList<Card>();

    // initialize prototype deck
    static {
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values())
                protoDeck.add(new Card(rank, suit));
    }
}
