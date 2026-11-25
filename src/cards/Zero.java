package cards;

import enums.Color;
import enums.Effect;

public class Zero extends Card {

    public Zero(Color color) {
        super(color, "Zero", Effect.NONE);
    }

    @Override
    public boolean canPlay(Card top) {
        return getColor().equals(top.getColor()) || top.getValue().equals("Zero") || anyCanPlay(top);
    }
}
