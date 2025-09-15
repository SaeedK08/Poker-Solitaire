package poker_solitaire.cardutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.smartcardio.CardException;

public class Pile {
    private ArrayList<Card> pile;

    public Pile() {
        this.pile = new ArrayList<Card>();
    }
    public Pile(ArrayList<Card> initialCards) {
        this.pile = new ArrayList<Card>(initialCards);
    }

    public void add(Card card) {
        this.pile.add(card);
    }
    public void add(List<Card> cardsToAdd) {
        this.pile.addAll(cardsToAdd);
    }
    public Card getCard(int index) {
        return pile.get(index);
    }
    public List<Card> getCards() {
        ArrayList<Card> copy = new ArrayList<>(pile);
        return copy;
    }
    public Card remove(int index) {
        return this.pile.remove(index);
    }
    public boolean remove(Card card) {
        return this.pile.remove(card);
    }
    public boolean remove(List<Card> cards) {
        for(Card c : cards) {
            if (!contains(c))
                return false;
        }

        return pile.removeAll(cards);
    }
    public int nrOfSuit(Suit suit) {
        int counter = 0;
        for(Card c : pile) {
            if(c.getCardSuit() == suit)
                counter++;
        }

        return counter;
    }
    public int nrOfRank(Rank rank) {
        int counter = 0;
        for(Card c : pile) {
            if(c.getCardRank() == rank)
                counter++;
        }
        return counter;
    }

    public boolean contains(Card card) {
        for(Card c: pile) {
            if (c.getCardRank() == card.getCardRank() && 
                c.getCardSuit() == card.getCardSuit())
                    return true;
        }
        return false;
    }
    public int getSize() {
        return pile.size();
    }
    public void clear() {
        pile.clear();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (getSize() > 0) {
            builder.append(pile.get(0).toShortString());
            for(int i = 1; i < getSize(); i++) {
                builder.append(pile.get(i).toShortString());
            }
        }
        builder.append("]");
        return builder.toString();
    }
}