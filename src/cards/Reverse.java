package cards;

import enums.Color;
import enums.Effect;

public class Reverse extends Card {
    public Reverse(Color color) {
        super(color, "cards.Reverse", Effect.REVERSE);
    }

    @Override
    public boolean canPlay(Card top) {
        return top.getValue().equals("cards.Reverse") || top.getColor().equals(this.getColor());
    }

    @Override
    public String message() {
        return "REVERSE";
    }

}
