package cards;

import enums.Color;
import enums.Effect;

public class Draw2 extends Card {
    public Draw2(Color color) {
        super(color, "cards.Draw2", Effect.DRAW2);
    }

    @Override
    public boolean canPlay(Card top) {
        return top.getValue().equals("cards.Draw2") || this.getColor().equals(top.getColor());
    }

    @Override
    public String message() {
        return "DRAW 2";
    }

}
