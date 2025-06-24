package mahjong.util;

/**
 * Global configuration class for the Mahjong game.
 * Provides static access to game settings across all classes.
 */
public class GameConfig {
    
    // Current language setting - accessible from anywhere
    private static Language currentLanguage = Language.ENGLISH;
    
    // Other potential global settings
    private static boolean debugMode = false;
    
    // Private constructor to prevent instantiation
    private GameConfig() {
        throw new UnsupportedOperationException("GameConfig is a utility class");
    }
    
    /**
     * Get the current language setting.
     * @return the current language
     */
    public static Language getLanguage() {
        return currentLanguage;
    }
    
    /**
     * Set the current language setting.
     * @param language the new language to set
     */
    public static void setLanguage(Language language) {
        if (language == null) {
            throw new IllegalArgumentException("Language cannot be null");
        }
        currentLanguage = language;
        System.out.println("Language changed to: " + language.getDisplayName());
    }
    
    /**
     * Get the language code (e.g., "en", "zh").
     * @return the current language code
     */
    public static String getLanguageCode() {
        return currentLanguage.getCode();
    }
    
    
    

    
    /**
     * Check if debug mode is enabled.
     * @return true if debug mode is enabled
     */
    public static boolean isDebugMode() {
        return debugMode;
    }
    
    /**
     * Enable or disable debug mode.
     * @param enabled true to enable debug mode, false to disable
     */
    public static void setDebugMode(boolean enabled) {
        debugMode = enabled;
    }
}
