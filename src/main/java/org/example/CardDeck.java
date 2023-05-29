package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardDeck {

    public static ArrayList<Card> make() {
        ArrayList<Card> newDeck = new ArrayList<>(36);
        for (CardSuits allCS : CardSuits.values()) {
            for (CardValues allCV : CardValues.values()) {
                newDeck.add(new Card(allCS, allCV));
            }
        }
        return newDeck;
    }

    public static void miksDeck(ArrayList<Card> cardDecs) {
        Random r = new Random();
        Collections.shuffle(cardDecs, r);
    }
}
