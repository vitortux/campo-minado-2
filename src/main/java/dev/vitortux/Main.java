package dev.vitortux;

import dev.vitortux.constants.Difficulty;
import dev.vitortux.game.Board;
import dev.vitortux.game.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Board board = new Board(Difficulty.MEDIUM, 5, 5, game);
        board.print();
    }
}