package dev.vitortux;

import dev.vitortux.constants.Difficulty;
import dev.vitortux.game.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(Difficulty.EASY, 3, 3);
    }
}