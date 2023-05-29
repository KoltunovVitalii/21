package org.example;

import java.util.ArrayList;

public class Game {
    Player player;
    Casino casino;

    public Game(Player player, Casino casino) {
        this.player = player;
        this.casino = casino;
    }

    public int result(ArrayList<Card> hand) {
        int res = 0;
        for (Card c : hand) {
            res += c.getCardValues().getData();
        }
        return res;

    }

    public String game(Player player, Casino casino) {
        ArrayList<Card> deck = CardDeck.make();
        CardDeck.miksDeck(deck);
        int resPl = 0;
        int resCas = 0;

        while (resPl < 20) {
            int indexOfLast = deck.size() - 1;
            player.getHand().add(deck.get(indexOfLast));
            resPl += deck.get(indexOfLast).getCardValues().getData();
            deck.remove(indexOfLast);
        }

        while (resCas < 20) {
            int indexOfLast = deck.size() - 1;
            casino.getHand().add(deck.get(indexOfLast));
            resCas += deck.get(indexOfLast).getCardValues().getData();
            deck.remove(indexOfLast);
        }

        String result = "НИЧЬЯ";

        if (resPl <= 21 & resCas <= 21) {
            if (resPl > resCas) {
                result = "ВЫЙГРАЛ: ИГРОК";
            } else if (resPl < resCas){
                result = "ВЫЙГРАЛ: КАЗИНО";
            }
        }
        if (resPl <= 21 && resCas > 21) {
            result = "ВЫЙГРАЛ: ИГРОК";
        }
        if (resPl > 21 && resCas <= 21) {
            result = "ВЫЙГРАЛ: КАЗИНО";
        }
        return result;
    }
}
