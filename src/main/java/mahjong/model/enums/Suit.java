package mahjong.model.enums;

import mahjong.util.GameConfig;
import mahjong.util.Language;

public enum Suit {
    DOT,
    BAMBOO,
    CHARACTER,
    WIND,
    DRAGON;

    public static Suit fromString(String suit) {
        switch (suit.toUpperCase()) {
            case "DOT":
                return DOT;
            case "BAMBOO":
                return BAMBOO;
            case "CHARACTER":
                return CHARACTER;
            case "WIND":
                return WIND;
            case "DRAGON":
                return DRAGON;
            default:
                throw new IllegalArgumentException("Unknown suit: " + suit);
        }
    }

    public String getDisplayName(Language lang){
        switch (this){
            case DOT:
                return lang == Language.CHINESE ? "筒" : "DOT";
            case BAMBOO:
                return lang == Language.CHINESE ? "索" : "BAMBOO";
            case CHARACTER:
                return lang == Language.CHINESE ? "萬" : "CHARACTER";
            case WIND:
                return lang == Language.CHINESE ? "风" : "WIND";
            case DRAGON:
                return lang == Language.CHINESE ? "龙" : "DRAGON";
            default:
                return this.name();
        }
    }

    public String getDisplayName(){
        return getDisplayName(GameConfig.getLanguage());
    }

}
