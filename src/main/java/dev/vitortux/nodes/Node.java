package dev.vitortux.nodes;

import dev.vitortux.nodes.observer.NodeObserver;

public interface Node {

    void reveal();

    void print();

    void addObserver(NodeObserver observer);
}
