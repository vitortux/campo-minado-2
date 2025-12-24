package dev.vitortux.game;

import dev.vitortux.nodes.observer.NodeObserver;

public class Game implements NodeObserver {

    private Board board;

    @Override
    public void onSafeNodeRevealed() {
        // TODO: Toca algum som, atualiza a interface, etc.
    }

    @Override
    public void onBombNodeRevealed() {
        // TODO: Efeitos de game-over.
    }
}
