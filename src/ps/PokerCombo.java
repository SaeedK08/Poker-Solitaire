package poker_solitaire.src.ps;

public enum PokerCombo {
    ROYAL_FLUSH(30), 
    STRAIGHT_FLUSH(30), 
    FOUR_OF_A_KIND(16), 
    FLUSH(5), 
    STRAIGHT(12),
    THREE_OF_A_KIND(6),
    TWO_PAIR(3),
    ONE_PAIR(2),
    HIGH_CARD(0);

    private final int value;
    
    private PokerCombo(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
/*
Royal Flush = 30 pts

Straight Flush = 30 pts

Four of a Kind = 16 pts

Full House = 10 pts

Flush = 5 pts

Straight = 12 pts

Three of a Kind = 6 pts

Two Pair = 3 pts

One Pair = 1 pt
*/