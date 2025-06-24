package mahjong.model.enums;

import mahjong.util.GameConfig;
import mahjong.util.Language;

public enum Wind {
    EAST,
    SOUTH, 
    WEST,
    NORTH;
    
    /**
     * Get the display name for this wind in the current language.
     * @return localized name of the wind
     */
    public String getDisplayName() {
        return getDisplayName(GameConfig.getLanguage());
    }
    
    /**
     * Get the display name for this wind in the specified language.
     * @param language the language to get the name in
     * @return localized name of the wind
     */
    public String getDisplayName(Language language) {
        switch (this) {
            case EAST:
                return language == Language.CHINESE ? "東" : "East";
            case SOUTH:
                return language == Language.CHINESE ? "南" : "South";
            case WEST:
                return language == Language.CHINESE ? "西" : "West";
            case NORTH:
                return language == Language.CHINESE ? "北" : "North";
            default:
                return this.name();
        }
    }
    
    @Override
    public String toString() {
        return getDisplayName();
    }
}
