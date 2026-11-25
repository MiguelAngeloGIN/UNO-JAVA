package cards;

import enums.Color;
import enums.Effect;

public class WildCard extends Card {
    public WildCard() {
        super(Color.NONE, "WildCard", Effect.WILDCARD);
    }

    @Override
    public boolean canPlay(Card top) {
        return true;
    }

    @Override
    public String message() {
        return "WILDCARD!!!";
    }

}
