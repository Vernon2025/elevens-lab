/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act02;

import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards. It provides several
 * operations including initialize, shuffle, deal, and check if empty.
 */
public class Deck {

    /**
     * cards contains all the cards in the deck.
     */
    private final List<Card> cards;

    private Deck deck;

    /**
     * size is the number of not-yet-dealt cards. Cards are dealt from the top
     * (highest index) down. The next card to be dealt is at size - 1.
     */
    private int size;

    /**
     * Creates a new <code>Deck</code> instance.<BR>
     * It pairs each element of ranks with each element of suits, and produces
     * one of the corresponding card. Cards should be created by rank, then by
     * suit. For example if ranks has 1 and 2 and suits has "clubs" and
     * "hearts", then cards should be created in this order: 1 clubs, 1 hearts,
     * 2 clubs, 2 hearts. It must be done this way for the test to pass!
     *
     * @param ranks is an array containing all of the card ranks.
     * @param suits is an array containing all of the card suits.
     * @param values is an array containing all of the card point values.
     */
    public Deck(String[] ranks, String[] suits, int[] values) {
        // Implemented in Activity 02
        cards = new ArrayList<>();

        for (int i = 0; i < ranks.length; i++) {
            for (String suit : suits) {
                cards.add(new Card(ranks[i], suit, values[i]));
            }
        }
        shuffle();
    }

    /**
     * Determines if this deck is empty (no undealt cards).
     *
     * @return true if this deck is empty, false otherwise.
     */
    public boolean isEmpty() {
        // Implemented in Activity 02

        return cards.isEmpty();
    }

    /**
     * Accesses the number of undealt cards in this deck.
     *
     * @return the number of undealt cards in this deck.
     */
    public int size() {
        // Implemented in Activity 02
        return cards.size();
    }

    /**
     * Deals a card from this deck. size is the index of the card that was last
     * dealt. If size == 0 then we've dealt all the cards and should return
     * null. Otherwise, the next card to be dealt is at index size-1
     *
     * @return the card just dealt, or null if all the cards have been
     * previously dealt.
     */
    public Card deal() {
        // Implemented in Activity 02
        if (isEmpty()) {
            return null;
        }
        return cards.remove(cards.size()-1);

    }

    /**
     * Randomly permute the given collection of cards and reset the size to
     * represent the entire deck.
     */
    public void shuffle() {
        // Implemented in Activity 04
        // *** DO NOT CHANGE THE CODE IN THIS METHOD ****
        shuffled = true;
    }

    /**
     * Generates and returns a string representation of this deck.
     *
     * @return a string representation of this deck.
     */
    @Override
    public String toString() {
        String rtn = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            rtn = rtn + cards.get(k);
            if (k != 0) {
                rtn = rtn + ", ";
            }
            if ((size - k) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\nDealt cards: \n";
        for (int k = cards.size() - 1; k >= size; k--) {
            rtn = rtn + cards.get(k);
            if (k != size) {
                rtn = rtn + ", ";
            }
            if ((k - cards.size()) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\n";
        return rtn;
    }

    /**
     * DO NOT MODIFY THIS METHOD OR THE TESTS WILL ALWAYS FAIL!! Gets the card
     * at index n. Used ONLY for the tester class to test the proper
     * construction of the cards in the deck.
     *
     * @param n
     * @return
     */
    public Card getCard(int n) {
        return cards.get(n);
    }

    public boolean shuffled = false;
}
