package poker_solitaire.cardutils;


import java.util.ArrayList;

public class DeckMain {
    public static void main(String[] args) {
       Deck deck = new Deck();
        deck.shuffle();

        // create two hands in a card game
        Pile hand1 = new Pile();
        Pile hand2 = new Pile();

        // deal five cards to each hand
        for(int i = 0; i < 5; i++) {
            hand1.add(deck.dealCard());
            hand2.add(deck.dealCard());
        }
        System.out.println("first hand : "+ hand1);
        System.out.println("second hand: " + hand2);

        // move the first card in the first hand to the second hand
        // Card c = hand1.remove(0);
        System.out.println(hand1.remove(new Card(Suit.CLUBS, Rank.SIX)));
        System.out.println(hand1.remove(new Card(Suit.HEARTS, Rank.SIX)));
        System.out.println(hand1.remove(new Card(Suit.SPADES, Rank.SIX)));
        System.out.println(hand1.remove(new Card(Suit.DIAMONDS, Rank.SIX)));
        System.out.println("first hand : "+ hand1);
        System.out.println("second hand: " + hand2);
        // clear both hands
        hand1.clear();
        hand2.clear();
        System.out.println("first hand : "+ hand1);
        System.out.println("second hand: " + hand2);
    }
}
