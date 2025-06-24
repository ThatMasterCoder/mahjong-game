package mahjong.model;

import mahjong.model.enums.Suit;

/**
 * Abstract base class for all Mahjong tiles.
 * Different tile types extend this class with their specific properties.
 */
public abstract class Tile {
    protected final Suit suit;
    
    protected Tile(Suit suit) {
        this.suit = suit;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    /**
     * Get a display representation of this tile.
     * @return string representation of the tile
     */
    public abstract String getDisplayName();
    
    /**
     * Check if this tile can form a sequence with other tiles.
     * Only numbered tiles can form sequences.
     * @return true if this tile can be part of a sequence
     */
    public abstract boolean canFormSequence();
    
    @Override
    public abstract boolean equals(Object obj);
    
    @Override
    public abstract int hashCode();
    

    @Override
    public String toString() {
        return getDisplayName();
    }
}
