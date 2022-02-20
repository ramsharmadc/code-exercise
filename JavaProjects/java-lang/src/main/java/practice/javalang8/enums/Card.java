package practice.javalang8.enums;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private static final List<Card> protoDeck = new ArrayList<Card>();

    // Initialize prototype deck
    static {
        for (final Suit suit : Suit.values()) {
            for (final Rank rank : Rank.values()) {
                protoDeck.add(new Card(rank, suit));
            }
        }
    }

    private final Rank rank;
    private final Suit suit;

    private Card(final Rank rank, final Suit suit) {

        this.rank = rank;
        this.suit = suit;
    }

    public static ArrayList<Card> newDeck() {

        return new ArrayList<Card>(protoDeck); // Return copy of prototype deck
    }

    public Rank rank() {

        return rank;
    }

    public Suit suit() {

        return suit;
    }

    @Override
    public String toString() {

        return rank + " of " + suit;
    }

    public enum Rank {
        DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }
}
