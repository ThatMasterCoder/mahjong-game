package mahjong.model;

import mahjong.model.enums.Suit;
import mahjong.model.enums.Wind;
import mahjong.util.GameConfig;
import mahjong.util.Language;

/**
 * Represents wind tiles (East, South, West, North).
 */
public class WindTile extends Tile {
    private final Wind wind;
    
    public WindTile(Wind wind) {
        super(Suit.WIND);
        this.wind = wind;
    }
    
    public Wind getWind() {
        return wind;
    }
    
    @Override
    public String getDisplayName() {
        return getDisplayName(GameConfig.getLanguage());
    }
    
    public String getDisplayName(Language language) {
        return wind.getDisplayName(language);
    }
    
    @Override
    public boolean canFormSequence() {
        return false; // Wind tiles cannot form sequences
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WindTile windTile = (WindTile) obj;
        return wind == windTile.wind;
    }
    
    @Override
    public int hashCode() {
        return wind.hashCode();
    }
}
