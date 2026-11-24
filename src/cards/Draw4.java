package cards;

import enums.Color;
import enums.Effect;

public class Draw4 extends Card {
    public Draw4() {
        super(Color.NONE, "cards.Draw4", Effect.DRAW4);
    }

    @Override
    public boolean canPlay(Card top) {
        return true;
    }

    @Override
    public String message() {
        return "DRAW 4";
    }

}
