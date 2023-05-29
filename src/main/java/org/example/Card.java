package org.example;

public class Card {
    private final CardSuits cardSuits;
    private final CardValues cardValues;

    public Card(CardSuits cardSuits, CardValues cardValues) {
        this.cardSuits = cardSuits;
        this.cardValues = cardValues;
    }

    public CardValues getCardValues() {
        return cardValues;
    }

    @Override
    public String toString() {
        return "Card: " +
                "cardSuits=" + cardSuits +
                ", cardValues=" + cardValues;
    }
}
