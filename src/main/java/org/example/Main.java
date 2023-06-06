package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int countWinPl = 0;
        int countWinCas = 0;
        int countWinNaN = 0;
        
        for (int i = 0; i < 1000; i++) {
            Player player = new Player("Player", Game.hand());
            Casino casino = new Casino("Casino", Game.hand());
            Game newGame = new Game(player, casino);
            if (newGame.game(player, casino).equals("НИЧЬЯ")) {
                countWinNaN++;
            } else if (newGame.game(player, casino).equals("ВЫЙГРАЛ: ИГРОК")) {
                countWinPl++;
            } else if (newGame.game(player, casino).equals("ВЫЙГРАЛ: КАЗИНО")) {
                countWinCas++;
            }
        }
        System.out.println("ИГРОК ВЫЙГРАЛ: " + countWinPl);
        System.out.println("КАЗИНО ВЫЙГРАЛ: " + countWinCas);
        System.out.println("НИЧЬЯ: " + countWinNaN);
    }
}