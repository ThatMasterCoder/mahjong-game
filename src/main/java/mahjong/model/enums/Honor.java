package mahjong.model.enums;

import mahjong.util.GameConfig;
import mahjong.util.Language;

public enum Honor {
    // Wind honors
    EAST_WIND,
    SOUTH_WIND,
    WEST_WIND,
    NORTH_WIND,
    
    // Dragon honors
    RED_DRAGON,
    GREEN_DRAGON,
    WHITE_DRAGON;
    
    /**
     * Check if this honor is a wind.
     * @return true if this is a wind honor
     */
    public boolean isWind() {
        return this == EAST_WIND || this == SOUTH_WIND || 
               this == WEST_WIND || this == NORTH_WIND;
    }
    
    /**
     * Check if this honor is a dragon.
     * @return true if this is a dragon honor
     */
    public boolean isDragon() {
        return this == RED_DRAGON || this == GREEN_DRAGON || this == WHITE_DRAGON;
    }
    
    /**
     * Get the wind direction if this is a wind honor.
     * @return the corresponding Wind enum value
     * @throws IllegalStateException if this is not a wind honor
     */
    public Wind getWind() {
        switch (this) {
            case EAST_WIND: return Wind.EAST;
            case SOUTH_WIND: return Wind.SOUTH;
            case WEST_WIND: return Wind.WEST;
            case NORTH_WIND: return Wind.NORTH;
            default: throw new IllegalStateException("Not a wind honor: " + this);
        }
    }
    
    /**
     * Get the dragon type if this is a dragon honor.
     * @return the corresponding Dragon enum value
     * @throws IllegalStateException if this is not a dragon honor
     */
    public Dragon getDragon() {
        switch (this) {
            case RED_DRAGON: return Dragon.RED;
            case GREEN_DRAGON: return Dragon.GREEN;
            case WHITE_DRAGON: return Dragon.WHITE;
            default: throw new IllegalStateException("Not a dragon honor: " + this);
        }
    }
    
    /**
     * Get the display name for this honor in the current language.
     * @return localized name of the honor
     */
    public String getDisplayName() {
        return getDisplayName(GameConfig.getLanguage());
    }
    
    /**
     * Get the display name for this honor in the specified language.
     * @param language the language to get the name in
     * @return localized name of the honor
     */
    public String getDisplayName(Language language) {
        switch (this) {
            case EAST_WIND:
                return language == Language.CHINESE ? "东" : "East";
            case SOUTH_WIND:
                return language == Language.CHINESE ? "南" : "South";
            case WEST_WIND:
                return language == Language.CHINESE ? "西" : "West";
            case NORTH_WIND:
                return language == Language.CHINESE ? "北" : "North";
            case RED_DRAGON:
                return language == Language.CHINESE ? "红" : "Red";
            case GREEN_DRAGON:
                return language == Language.CHINESE ? "发" : "Green";
            case WHITE_DRAGON:
                return language == Language.CHINESE ? "白" : "White";
            default:
                return this.name();
        }
    }
    
    @Override
    public String toString() {
        return getDisplayName();
    }
}
