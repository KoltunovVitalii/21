package org.example;

import java.util.ArrayList;

public class Participant {
    private final String name;
    private ArrayList<Card> hand;

    public Participant(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
