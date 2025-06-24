package mahjong.model;

import java.util.Stack;

public class DiscardPile {
    private Stack<Tile> discardedTiles;
    
    public DiscardPile() {
        this.discardedTiles = new Stack<>();
    }

    public Tile addTile(Tile tile) {
        return discardedTiles.push(tile);
    }

    public Tile removeTile() {
        if (!discardedTiles.isEmpty()) {
            return discardedTiles.pop();
        }
        throw new IllegalStateException("No tiles to remove from the discard pile.");
    }

    public Tile peek(){
        if (!discardedTiles.isEmpty()) {
            return discardedTiles.peek();
        }
        throw new IllegalStateException("No tiles in the discard pile to peek at.");
    }

    public boolean isEmpty() {
        return discardedTiles.isEmpty();
    }

    public int size() {
        return discardedTiles.size();
    }

    
}
