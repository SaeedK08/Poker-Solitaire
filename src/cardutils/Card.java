package poker_solitaire.src.cardutils;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getCardRank() {
        return this.rank;
    }
    public Suit getCardSuit() {
        return this.suit;
    }
    public int getRankValue() {
        return this.rank.getValue();
    }
    public int getSuitValue() {
        return this.suit.ordinal();
    }

    @Override
    public String toString() {
        return "Card [rank=" + rank + ", suit=" + suit + "]";
    }
    public String toShortString() {
        String info = "";
        switch (this.rank) {
            case ACE: info += 'A';
                break;
            case KING: info += 'K';
                break;
            case QUEEN: info += 'Q';
                break;
            case JACK: info += 'J';
                break;
            default: info += getRankValue();
        }
        switch (this.suit) {
            case SPADES: info += '\u2660';
			    break;
		    case HEARTS: info += '\u2764';
			    break;
		    case CLUBS: info += '\u2663';
                break;      
		    case DIAMONDS: info += '\u2666';
			    break;
            default: break;
        }   
        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj instanceof Card) {
            Card c = (Card) obj;
            return this.rank == c.getCardRank() && this.suit == c.getCardSuit(); 
        }
        return false;
    }
}