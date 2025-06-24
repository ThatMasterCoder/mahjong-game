package mahjong.model;

import mahjong.model.enums.Honor;
import mahjong.model.enums.Suit;
import mahjong.util.GameConfig;
import mahjong.util.Language;

/**
 * Represents honor tiles (winds and dragons).
 * Honor tiles cannot form sequences, only triplets and quadruplets.
 */
public class HonorTile extends Tile {
    private final Honor honor;
    
    public HonorTile(Honor honor) {
        super(honor.isWind() ? Suit.WIND : Suit.DRAGON);
        this.honor = honor;
    }
    
    public Honor getHonor() {
        return honor;
    }
    
    /**
     * Check if this is a wind tile.
     * @return true if this honor tile represents a wind
     */
    public boolean isWind() {
        return honor.isWind();
    }
    
    /**
     * Check if this is a dragon tile.
     * @return true if this honor tile represents a dragon
     */
    public boolean isDragon() {
        return honor.isDragon();
    }
    
    @Override
    public String getDisplayName() {
        return getDisplayName(GameConfig.getLanguage());
    }
    
    public String getDisplayName(Language language) {
        return honor.getDisplayName(language);
    }
    
    @Override
    public boolean canFormSequence() {
        return false; // Honor tiles cannot form sequences
    }
    
    /**
     * Check if this honor tile matches a specific wind (useful for scoring).
     * @param expectedWind the wind to check against
     * @return true if this is a wind tile matching the expected wind
     */
    public boolean isWindMatching(mahjong.model.enums.Wind expectedWind) {
        return isWind() && honor.getWind() == expectedWind;
    }
    
    /**
     * Check if this honor tile matches a specific dragon (useful for scoring).
     * @param expectedDragon the dragon to check against
     * @return true if this is a dragon tile matching the expected dragon
     */
    public boolean isDragonMatching(mahjong.model.enums.Dragon expectedDragon) {
        return isDragon() && honor.getDragon() == expectedDragon;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HonorTile honorTile = (HonorTile) obj;
        return honor == honorTile.honor;
    }
    
    @Override
    public int hashCode() {
        return honor.hashCode();
    }
}
