package mahjong;

import mahjong.logic.Scorer;
import mahjong.util.GameConfig;
import mahjong.util.Language;
import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Initialize game with default language
        System.out.println("Welcome to Mahjong Game!");

        
        if (args.length > 0) {
            if (args[0].equals("debug=false")){
                GameConfig.setDebugMode(false);
            } else if (args[0].equals("debug=true")){
                GameConfig.setDebugMode(true);
                System.out.println("DEBUG MODE ENABLED!");
            } else {
                throw new IllegalArgumentException("Invalid argument: " + args[0]);
            }        } // else: debug is false by default. 
        else {
            GameConfig.setDebugMode(false);
        }

        // Language selection interface
        System.out.println("\n" + "=".repeat(40));
        System.out.println("        LANGUAGE SELECTION");
        System.out.println("=".repeat(40));
        
        Language selectedLanguage = null;
        
        while (selectedLanguage == null) {            System.out.println("\nPlease select your language:");
            System.out.println("1. English");
            System.out.println("2. 中文 (Chinese)");
            System.out.print("\nEnter your choice (1 or 2): ");
            
            try {
                String input = scanner.nextLine().trim();
                
                switch (input) {
                    case "1":
                        selectedLanguage = Language.ENGLISH;
                        break;
                    case "2":
                        selectedLanguage = Language.CHINESE;
                        break;                    
                    default:
                        System.out.println("❌ Invalid choice! Please enter 1 or 2.");
                        continue;
                }
                
                // Set the selected language
                GameConfig.setLanguage(selectedLanguage);
                  // Display confirmation in the selected language
                if (selectedLanguage == Language.ENGLISH) {
                    System.out.println("✅ Language set to English!");
                    System.out.println("Welcome to Mahjong Game!");
                } else {
                    System.out.println("✅ 语言设置为中文！");
                    System.out.println("欢迎来到麻将游戏！");
                }
                  
            } catch (Exception e) {
                System.out.println("❌ Error reading input. Please try again.");
            }
        }
        
        System.out.println("\n" + "=".repeat(40));
        
        if (GameConfig.isDebugMode()) {
            System.out.println("Debug Info:");
            System.out.println("- Language: " + GameConfig.getLanguage().getDisplayName());
            System.out.println("- Language Code: " + GameConfig.getLanguageCode());
            System.out.println("- Debug Mode: " + GameConfig.isDebugMode());
        }
        


        
    }
}
