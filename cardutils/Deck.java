package poker_solitaire.cardutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private static final ArrayList<Card> protoDeck = new ArrayList<>();
    private final ArrayList<Card> theCards;

    static {
        for(Suit s: Suit.values()) {
            for(Rank r: Rank.values()) {
                protoDeck.add(new Card(s,r));
            }
        }
    }
    public Deck() {
        this.theCards = new ArrayList<Card>();
        fill();
    }

    public void fill() {
        this.theCards.clear();
        this.theCards.addAll(protoDeck);
    }
    public void shuffle() {
        Collections.shuffle(theCards);
    }
    public Card dealCard() {
        return theCards.remove(getSize() - 1);
    }
    public int getSize() {
        return this.theCards.size();
    }

    @Override 
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (getSize() > 0) {
            builder.append(this.theCards.get(0).toShortString());
            for(int i = 1; i < getSize(); i++) {
                builder.append(", " + this.theCards.get(i).toShortString());
            }
        }
        builder.append("]");
        return builder.toString();
    }
}