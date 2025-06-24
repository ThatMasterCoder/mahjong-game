package mahjong.game;

import mahjong.util.GameConfig;
import mahjong.util.Language;

/**
 * Example game class showing how to access language settings.
 */
public class GameEngine {
      public void startGame() {
        // Access language from anywhere in your code
        Language currentLang = GameConfig.getLanguage();
        
        switch (currentLang) {
            case ENGLISH:
                System.out.println("Starting game...");
                break;
            case CHINESE:
                System.out.println("开始游戏...");
                break;
            default:
                System.out.println("Warning: Unsupported language. Defaulting to English.");
                System.out.println("Starting game...");
                break;
        }
    }
    
    public void displayWelcomeMessage() {
        // Another example of accessing language
        String langCode = GameConfig.getLanguageCode();
        System.out.println("Game running in language: " + langCode);
        System.out.println("Language display name: " + GameConfig.getLanguage().getDisplayName());
    }
}
