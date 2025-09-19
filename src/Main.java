package poker_solitaire.src;

public class Main {
    public static void main(String[] args) {
        PsUserInterface tui = new PsUserInterface();
        tui.run(); 
    }
}


// Test for getPokerCombo in PokerHands
/*
Pile hand = new Pile();
hand.add(new Card(Suit.HEARTS, Rank.ACE));
hand.add(new Card(Suit.SPADES, Rank.TEN));
hand.add(new Card(Suit.CLUBS, Rank.SEVEN));
hand.add(new Card(Suit.DIAMONDS, Rank.NINE));
hand.add(new Card(Suit.CLUBS, Rank.TWO));

PokerCombo combo;
combo = PokerHands.getPokerCombo(hand);
System.out.println(combo);
 */