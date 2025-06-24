package mahjong.model.enums;

import mahjong.util.GameConfig;
import mahjong.util.Language;

/* USAGE:
     * // Set language globally
GameConfig.setLanguage(Language.CHINESE);

// These will now display in Chinese
System.out.println(MeldType.PONG); // Prints: 碰
System.out.println(CallType.WOO);  // Prints: 胡

// Switch back to English
GameConfig.setLanguage(Language.ENGLISH);
System.out.println(MeldType.PONG); // Prints: Pong

// Or get specific language without changing global setting
String chineseName = MeldType.KONG.getDisplayName(Language.CHINESE); // 杠


     */

public enum MeldType {
    PONG, // Three of a kind
    CHOW, // Sequence of three tiles
    KONG, // Four of a kind
    PAIR; // Two of a kind
    

    
    /**
     * Get the display name for this meld type in the current language.
     * @return localized name of the meld type
     */
    public String getDisplayName() {
        return getDisplayName(GameConfig.getLanguage());
    }
    
    /**
     * Get the display name for this meld type in the specified language.
     * @param language the language to get the name in
     * @return localized name of the meld type
     */
    public String getDisplayName(Language language) {
        switch (this) {
            case PONG:
                return language == Language.CHINESE ? "碰" : "PONG";
            case CHOW:
                return language == Language.CHINESE ? "吃" : "CHOW";
            case KONG:
                return language == Language.CHINESE ? "杠" : "KONG";
            case PAIR:
                return language == Language.CHINESE ? "对" : "PAIR";
            default:
                return this.name();
        }
    }
    
    @Override
    public String toString() {
        return getDisplayName();
    }
}
