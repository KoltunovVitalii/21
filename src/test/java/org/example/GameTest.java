package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    @Test
    void testExample() {
        //given определяем объекты, с коротыми взаимодействуем
        boolean b = true;
        //when обработка бизнес логики, вызываем методы и т.п.
        //then проверка, сравнение результата теста с целевыми
        Assertions.assertTrue(b, "ACHTUNG!");

    }

    @Test
    void testResult(){
        Game game = new Game(new Player("S", new ArrayList<>()), new Casino("AAA", new ArrayList<>()));
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardSuits.DIAMONDS, CardValues.Seven));
        hand.add(new Card(CardSuits.HEARTS, CardValues.Seven));

        int result = game.result(hand);

        Assertions.assertEquals(14, result, "fff");
    }

    @Test
    void testHand(){
        int result = 0;
        ArrayList<Card> deck = new ArrayList<>();
        Card card = new Card(CardSuits.DIAMONDS, CardValues.Seven);
        Card card2 = new Card(CardSuits.HEARTS, CardValues.Seven);
        Card card3 = new Card(CardSuits.CLUBS, CardValues.Seven);
        deck.add(card);
        deck.add(card2);
        deck.add(card3);

        Player player = new Player("b", new ArrayList<>());

        while (result < 19) {
            int indexOfLast = deck.size() - 1;
            player.getHand().add(deck.get(indexOfLast));
            result += deck.get(indexOfLast).getCardValues().getData();
            deck.remove(indexOfLast);
        }
        Assertions.assertEquals(21, result, "fff");
    }

    @Test
    void testGame() {
        Player player = new Player("S", new ArrayList<>());
        Casino casino = new Casino("AAA", new ArrayList<>());
        Game game = new Game(player, casino);
        Card card = new Card(CardSuits.DIAMONDS, CardValues.Seven);
        Card card2 = new Card(CardSuits.HEARTS, CardValues.Seven);
        Card card3 = new Card(CardSuits.CLUBS, CardValues.Seven);
        Card card4 = new Card(CardSuits.CLUBS, CardValues.ACE);
        Card card5 = new Card(CardSuits.CLUBS, CardValues.TEN);
        player.getHand().add(card);
        player.getHand().add(card2);
        player.getHand().add(card3);
        casino.getHand().add(card4);
        casino.getHand().add(card5);
        String res = game.game(player, casino);

        Assertions.assertEquals("НИЧЬЯ", res, "ВНИМАНИЕ!");
    }


}
