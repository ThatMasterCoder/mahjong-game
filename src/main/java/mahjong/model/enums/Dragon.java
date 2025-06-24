package mahjong.model.enums;

import mahjong.util.GameConfig;
import mahjong.util.Language;

public enum Dragon {
    RED,
    GREEN,
    WHITE;
    
    /**
     * Get the display name for this dragon in the current language.
     * @return localized name of the dragon
     */
    public String getDisplayName() {
        return getDisplayName(GameConfig.getLanguage());
    }
    
    /**
     * Get the display name for this dragon in the specified language.
     * @param language the language to get the name in
     * @return localized name of the dragon
     */
    public String getDisplayName(Language language) {
        switch (this) {
            case RED:
                return language == Language.CHINESE ? "红" : "Red";
            case GREEN:
                return language == Language.CHINESE ? "發" : "Green";
            case WHITE:
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
