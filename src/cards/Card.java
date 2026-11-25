package cards;

import enums.Color;
import enums.Effect;

public abstract class Card {
    private final Color color;
    private final String value;
    private final Effect effect;

    Card(Color color,  String value, Effect effect) {
        this.color = color;
        this.value = value;
        this.effect = effect;
    }

    public Color getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public Effect getEffect() {
        return effect;
    }

    public abstract boolean canPlay(Card top);

    public String message() {
        return "";
    }


}
