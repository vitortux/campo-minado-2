package dev.vitortux.constants;

import lombok.Getter;

@Getter
public enum Difficulty {

    EASY(10, 8, 10),
    MEDIUM(18, 14, 40),
    HARD(24, 20, 99);

    private int rows;

    private int cols;

    private int mines;

    Difficulty(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
    }
}
