package dev.vitortux.nodes.impl;

import java.util.ArrayList;
import java.util.List;

import dev.vitortux.nodes.Node;
import dev.vitortux.nodes.observer.NodeObserver;

public class BombNodeImpl implements Node {

    private boolean revealed = false;

    private final List<NodeObserver> observers = new ArrayList<>();

    @Override
    public void reveal() {
        if (revealed)
            return;

        revealed = true;
        observers.forEach(NodeObserver::onBombNodeRevealed);
    }

    @Override
    public void addObserver(NodeObserver o) {
        observers.add(o);
    }

    @Override
    public void print() {
        System.out.print(" * ");
    }
}
