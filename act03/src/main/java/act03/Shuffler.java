/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act03;

import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

    /**
     * Apply a "perfect shuffle" to the argument. The perfect shuffle algorithm
     * splits the deck in half, then interleaves the cards in one half with the
     * cards in the other. See the code in Tester.java for an example of how the
     * interleaving works.
     *
     * @param values is an array of integers simulating cards to be shuffled.
     * @return the shuffled array
     */
    public static int[] perfectShuffle(int[] values) {
        int cards = values.length;
        int[] shuffledCards = new int[cards];
        int temp = 0;
        int mid = cards / 2;
    
        if ((cards % 2) == 0) {
            for (int i = 0; i < mid; i++) {
                shuffledCards[temp] = values[i];
                shuffledCards[temp + 1] = values[i + mid];
                temp = temp + 2;
            }
        } else {
            for (int i = 0; i < mid; i++) {
                shuffledCards[temp] = values[i];
                shuffledCards[temp + 1] = values[i + mid + 1];
                temp = temp + 2;
            }
    
            shuffledCards[temp] = values[mid];
        }
    
        return shuffledCards;
    }
    
    

    /**
     * Apply an "efficient selection shuffle" to the argument. The selection
     * shuffle algorithm conceptually maintains two sequences of cards: the
     * selected cards (initially empty) and the not-yet-selected cards
     * (initially the entire deck). It repeatedly does the following until all
     * cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards. An efficient version of this
     * algorithm makes use of arrays to avoid searching for an as-yet-unselected
     * card.
     *
     * @param values is an array of integers simulating cards to be shuffled.
     * @return the shuffled array
     */
    public static int[] selectionShuffle(int[] values) {
        Random rand = new Random();

        for (int i = values.length - 1; i > 0; i--) {
            int randIndex = rand.nextInt(i + 1);
            int temp = values[i];
            values[i] = values[randIndex];
            values[randIndex] = temp;
        }

        return values;
    }
}
