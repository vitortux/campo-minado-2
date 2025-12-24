package dev.vitortux.game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import dev.vitortux.constants.Difficulty;
import dev.vitortux.model.Position;
import dev.vitortux.nodes.Node;
import dev.vitortux.nodes.impl.BombNodeImpl;
import dev.vitortux.nodes.impl.NodeImpl;
import dev.vitortux.nodes.observer.NodeObserver;

public class Board {

    private Node[][] nodes;

    private int mines;

    public Board(Difficulty difficulty, int firstRow, int firstCol, NodeObserver observer) {
        int rows = difficulty.getRows();
        int cols = difficulty.getCols();

        this.mines = difficulty.getMines();
        this.nodes = new Node[rows][cols];

        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int row = i / nodes[0].length;
            int col = i % nodes[0].length;
            Node node = new NodeImpl();
            node.addObserver(observer);
            nodes[row][col] = node;
        }

        Random random = new Random();
        Set<Position> positions = new HashSet<>();
        Position firstMove = new Position(firstRow, firstCol);

        while (positions.size() < mines) {
            int row = random.nextInt(nodes.length);
            int col = random.nextInt(nodes[0].length);

            Position candidate = new Position(row, col);

            if (candidate.isWithinDistance(firstMove, 1))
                continue;

            positions.add(candidate);
        }

        for (Position p : positions) {
            Node bomb = new BombNodeImpl();
            bomb.addObserver(observer);
            nodes[p.row()][p.col()] = bomb;
        }
    }

    // TODO: Mover esse método para uma classe dedicada de interface.
    public void print() {
        System.out.print("   ");

        for (int col = 0; col < nodes.length; col++) {
            System.out.printf("%2c ", (char) ('A' + col));
        }
        System.out.println();

        for (int i = 0; i < nodes.length * nodes[0].length; i++) {
            int col = i / nodes.length;
            int row = i % nodes.length;

            if (row == 0) {
                System.out.printf("%2d ", col + 1);
            }

            nodes[row][col].print();

            if (row == nodes.length - 1) {
                System.out.println();
            }
        }
    }
}
