package cards;

import enums.Color;
import enums.Effect;

public class Skip extends Card {
    public Skip(Color color) {
        super(color, "cards.Skip", Effect.SKIP);
    }

    @Override
    public boolean canPlay(Card top) {
        return top.getValue().equals("cards.Skip") || top.getColor().equals(this.getColor());
    }

    @Override
    public String message() {
        return "SKIP";
    }

}
