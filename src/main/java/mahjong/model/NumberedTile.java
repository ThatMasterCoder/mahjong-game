package mahjong.model;

import mahjong.model.enums.Suit;
import mahjong.util.GameConfig;
import mahjong.util.Language;

/**
 * Represents numbered tiles (DOT, BAMBOO, CHARACTER) with ranks 1-9.
 */
public class NumberedTile extends Tile {
    private final int rank;
    
    public NumberedTile(Suit suit, int rank) {
        super(suit);
        if (suit != Suit.DOT && suit != Suit.BAMBOO && suit != Suit.CHARACTER) {
            throw new IllegalArgumentException("NumberedTile can only be DOT, BAMBOO, or CHARACTER suit");
        }
        if (rank < 1 || rank > 9) {
            throw new IllegalArgumentException("Rank must be between 1 and 9");
        }
        this.rank = rank;
    }
    
    public int getRank() {
        return rank;
    }
    
    @Override
    public String getDisplayName() {
        return getDisplayName(GameConfig.getLanguage());
    }
    
    public String getDisplayName(Language language) {
        String suitName = suit.getDisplayName(language);
        if (language == Language.CHINESE) {
            return rank + suitName;
        } else {
            return rank + " " + suitName;
        }
    }
    
    @Override
    public boolean canFormSequence() {
        return true; // Numbered tiles can form sequences
    }
    
    /**
     * Check if this tile is consecutive with another numbered tile of the same suit.
     * @param other the other tile to check
     * @return true if tiles are consecutive
     */
    public boolean isConsecutive(NumberedTile other) {
        return this.suit == other.suit && Math.abs(this.rank - other.rank) == 1;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NumberedTile that = (NumberedTile) obj;
        return rank == that.rank && suit == that.suit;
    }
    
    @Override
    public int hashCode() {
        return suit.hashCode() * 31 + rank;
    }
}
