package dev.vitortux.nodes.impl;

import java.util.ArrayList;
import java.util.List;

import dev.vitortux.nodes.Node;
import dev.vitortux.nodes.observer.NodeObserver;

public class NodeImpl implements Node {

    private boolean revealed = false; // TODO Adicionar estados (revelado, marcado, etc)

    // TODO Adicionar um set de vizinhos dentro de cada row, p/ reveal em cadeia

    private final List<NodeObserver> observers = new ArrayList<>();

    // * O reveal deve sempre chamar o reveal do state para céulas seguras
    @Override
    public void reveal() {
        if (revealed)
            return;

        revealed = true;
        observers.forEach(NodeObserver::onSafeNodeRevealed);
    }

    @Override
    public void addObserver(NodeObserver o) {
        observers.add(o);
    }

    @Override
    public void print() {
        System.out.print(" . ");
    }
}
