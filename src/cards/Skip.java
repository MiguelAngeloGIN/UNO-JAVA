package cards;

import enums.Color;
import enums.Effect;

public class Skip extends Card {
    public Skip(Color color) {
        super(color, "Skip", Effect.SKIP);
    }

    @Override
    public boolean canPlay(Card top) {
        return top.getValue().equals("Skip") || top.getColor().equals(this.getColor()) || anyCanPlay(top);
    }

    @Override
    public String message() {
        return "SKIP";
    }

}
