package cards;

import enums.Color;
import enums.Effect;

public class RegularCard extends Card {

    public RegularCard(Color color, String value) {
        super(color, value, Effect.NONE);
    }

    @Override
    public boolean canPlay(Card top) {
        return getColor().equals(top.getColor()) || getValue().equals(top.getValue());
    }
}
