package poker_solitaire.ps;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import poker_solitaire.cardutils.Card;
import poker_solitaire.cardutils.Deck;
import poker_solitaire.cardutils.Pile;

public class PsLogic implements IPsLogic {
    private Card nextCard;
    private ArrayList<Pile> piles;
    private Deck deck;
    private int cardCount;
    

    public PsLogic() {
        piles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            piles.add(new Pile());
        }
        deck = new Deck();
    }

    public void initNewGame() {
        deck.fill();
        deck.shuffle();
        for(int i = 0; i < piles.size(); i++) {
            piles.get(i).clear();
        }
        cardCount = 0;
        nextCard = null;
    }

    public int getCardCount() {
        return this.cardCount;
    }

    public Card pickNextCard() {
        if (nextCard == null) {
            nextCard = deck.dealCard();
            return nextCard;
        }
        else 
            throw new IllegalStateException(" Can't pick another card ");
    }
    
    public void addCardToPile(int pileIndex) {
        if (nextCard != null) {
            piles.get(pileIndex).add(nextCard);
            nextCard = null;
            cardCount++;
        }
        else 
            throw new IllegalStateException(" Can't add card to the pile ");
    }

    public List<Pile> getPiles() {
        ArrayList<Pile> copy = new ArrayList<>(piles);
        return copy;
    }

    public boolean isGameOver() {
        return cardCount==25;
    }

    public int getPoints() {
        int points = 0;
        for(Pile p : piles) {
            PokerCombo combo = PokerHands.getPokerCombo(p);
            points += combo.getValue();
        }
        return points;
    }

    @Override
    public String toString() {
        return "PsLogic [nextCard=" + nextCard + ", piles=" + piles + ", deck=" + deck + ", cardCount=" + cardCount
                + "]";
    }

    

}