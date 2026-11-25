package cards;

import enums.Color;
import enums.Effect;

public class Regular extends Card {

    public Regular(Color color, String value) {
        super(color, value, Effect.NONE);
    }

    @Override
    public boolean canPlay(Card top) {
        return getColor().equals(top.getColor()) || getValue().equals(top.getValue());
    }
}
