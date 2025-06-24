package mahjong.model;

import mahjong.model.enums.Dragon;
import mahjong.model.enums.Suit;
import mahjong.util.GameConfig;
import mahjong.util.Language;

/**
 * Represents dragon tiles (Red, Green, White).
 */
public class DragonTile extends Tile {
    private final Dragon dragon;
    
    public DragonTile(Dragon dragon) {
        super(Suit.DRAGON);
        this.dragon = dragon;
    }
    
    public Dragon getDragon() {
        return dragon;
    }
    
    @Override
    public String getDisplayName() {
        return getDisplayName(GameConfig.getLanguage());
    }
    
    public String getDisplayName(Language language) {
        return dragon.getDisplayName(language);
    }
    
    @Override
    public boolean canFormSequence() {
        return false; // Dragon tiles cannot form sequences
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DragonTile dragonTile = (DragonTile) obj;
        return dragon == dragonTile.dragon;
    }
    
    @Override
    public int hashCode() {
        return dragon.hashCode();
    }
}
