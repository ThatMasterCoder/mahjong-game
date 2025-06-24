package mahjong.util;

/**
 * Enum representing supported languages in the Mahjong game.
 */
public enum Language {
    ENGLISH("en", "English"),
    CHINESE("zh", "中文");
    
    private final String code;
    private final String displayName;
    
    Language(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}
