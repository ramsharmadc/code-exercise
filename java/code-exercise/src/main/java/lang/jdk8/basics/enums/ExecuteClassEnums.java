package lang.jdk8.basics.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExecuteClassEnums {

    public static ArrayList<Card> deal(final List<Card> deck, final int n) {

        final int deckSize = deck.size();
        final List<Card> handView = deck.subList(deckSize - n, deckSize);
        final ArrayList<Card> hand = new ArrayList<Card>(handView);
        handView.clear();
        return hand;
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {

        // TODO Auto-generated method stub

        /* UsingEnums enumObj = new UsingEnums(); */

        final int numHands = 4;
        final int cardsPerHand = 5;
        final List<Card> deck = Card.newDeck();
        Collections.shuffle(deck);
        for (int i = 0; i < numHands; i++) {
            System.out.println(deal(deck, cardsPerHand));
        }
    }
}
