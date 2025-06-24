package mahjong.model.enums;

import mahjong.util.GameConfig;
import mahjong.util.Language;

/**
 * For usage:
     * @see mahjong.model.enums.MeldType
     */
public enum CallType {
    WOO, // win
    KONG, 
    PONG,
    CHOW,
    NONE;
    
    /**
     * Get the display name for this call type in the current language.
     * @return localized name of the call type
     */
    public String getDisplayName() {
        return getDisplayName(GameConfig.getLanguage());
    }
    
    /**
     * Get the display name for this call type in the specified language.
     * @param language the language to get the name in
     * @return localized name of the call type
     */
    public String getDisplayName(Language language) {
        switch (this) {
            case WOO:
                return language == Language.CHINESE ? "胡" : "WIN";
            case KONG:
                return language == Language.CHINESE ? "杠" : "KONG";
            case PONG:
                return language == Language.CHINESE ? "碰" : "PONG";
            case CHOW:
                return language == Language.CHINESE ? "吃" : "CHOW";
            case NONE:
                return language == Language.CHINESE ? "无" : "NONE";
            default:
                return this.name();
        }
    }
    
    @Override
    public String toString() {
        return getDisplayName();
    }
}
