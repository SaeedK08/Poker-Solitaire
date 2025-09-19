package poker_solitaire.src.ps;

import java.util.Arrays;

import poker_solitaire.src.cardutils.Pile;
import poker_solitaire.src.cardutils.Rank;
import poker_solitaire.src.cardutils.Suit;

public class PokerHands {
    private PokerHands() {
        // Prevent instantiation
    }
    public static PokerCombo getPokerCombo(Pile hand) {
        boolean flush = false;
        int[] rankFreq = new int[13];

        // Check for flush
        for(Suit s : Suit.values()) {
            if (hand.nrOfSuit(s) == hand.getSize())
                flush = true;
        }
        
        for(Rank r : Rank.values()) {
            rankFreq[r.getValue() - 1] = hand.nrOfRank(r);
        }

        switch (getHighestRankFreq(rankFreq)) {
            case 1:
                if (flush && isRoyalFlush(hand))
                    return PokerCombo.ROYAL_FLUSH;
                if (flush && isRankConsecutive(hand))
                    return PokerCombo.STRAIGHT_FLUSH;
                if (!flush && isRankConsecutive(hand))
                    return PokerCombo.STRAIGHT;
                if (flush) 
                    return PokerCombo.FLUSH; 
                
                return PokerCombo.HIGH_CARD;

            case 2: 
                if (checkForDuplicates(rankFreq)) 
                    return PokerCombo.TWO_PAIR;
                else 
                    return PokerCombo.ONE_PAIR;
                
            case 3:
                return PokerCombo.THREE_OF_A_KIND;
            case 4:
                return PokerCombo.FOUR_OF_A_KIND;
            default:
                return PokerCombo.HIGH_CARD;
        }
    }
    private static boolean checkForDuplicates(int[] array) {
        int freq = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 2)  freq++;
        }
        return freq == 2;
    }

    private static int getHighestRankFreq(int[] rankFreq) {
        int highestFreq = 0;
        for (int i = 0; i < rankFreq.length; i++) {
            if (rankFreq[i] > highestFreq)
                highestFreq = rankFreq[i];
        }
        return highestFreq;
    }

    private static boolean isRankConsecutive(Pile hand) {
        int [] rankValues = new int[hand.getSize()];
        for (int i = 0; i < hand.getSize(); i++) {
            rankValues[i] = hand.getCard(i).getRankValue();
        }
        Arrays.sort(rankValues);
        for (int i = 0; i < rankValues.length - 1; i++) {
            if (rankValues[i] == 1) {
                if (rankValues[i+1] == Rank.TWO.getValue());
                if (rankValues[i+1] == Rank.TEN.getValue())
                    rankValues[i] = Rank.TEN.getValue() - 1;
            }
            if (rankValues[i] < rankValues[i+1] - 1)
                return false;
        }
        return true;
    }

    private static boolean isRoyalFlush(Pile hand) {
        if (isRankConsecutive(hand)) {
            return hand.nrOfRank(Rank.ACE) == 1 && hand.nrOfRank(Rank.KING) == 1;
        }
        return false;
    }
}

