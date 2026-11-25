package cards;

import enums.Color;
import enums.Effect;

public class Reverse extends Card {
    public Reverse(Color color) {
        super(color, "Reverse", Effect.REVERSE);
    }

    @Override
    public boolean canPlay(Card top) {
        return top.getValue().equals("Reverse") || top.getColor().equals(this.getColor()) || anyCanPlay(top);
    }

    @Override
    public String message() {
        return "REVERSE";
    }

}
