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

    public static ArrayList<Card> hand() {
        ArrayList<Card> deck = CardDeck.make();
        CardDeck.miksDeck(deck);
        int result = 0;
        ArrayList<Card> hand = new ArrayList<>();
        while (result < 19) {
            int indexOfLast = deck.size() - 1;
            hand.add(deck.get(indexOfLast));
            result += deck.get(indexOfLast).getCardValues().getData();
            deck.remove(indexOfLast);
        }

        return hand;
    }

    public String game(Player player, Casino casino) {

        ArrayList<Card> plHand = player.getHand();
        ArrayList<Card> casHand = casino.getHand();

        int resPl = result(plHand);
        int resCas = result(casHand);

        String result = "НИЧЬЯ";

        if (resPl <= 21 && resCas <= 21) {
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
