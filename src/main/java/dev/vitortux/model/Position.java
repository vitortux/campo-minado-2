package dev.vitortux.model;

public record Position(int row, int col) {

    public boolean isWithinDistance(Position other, int d) {
        return Math.abs(row - other.row) <= d && Math.abs(col - other.col) <= d;
    }
}
