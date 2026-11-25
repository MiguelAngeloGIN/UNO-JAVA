import cards.Card;
import enums.Effect;
import java.util.ArrayList;
import java.util.Stack;

public class EffectHandler {

    public static int effectHandler(Card card, Player player, ArrayList<Player> sequence,
                                    Stack<Card> drawDeck) {
        Effect effect = card.getEffect();
        int cur = sequence.indexOf(player);


        switch (effect){
            case DRAW2:
                cur ++;
                player = sequence.get(cur);
                for (int i = 1; i < 3; i++) {
                    Card drawnCard = drawDeck.pop();
                    player.addCard(drawnCard);
                }
                break;

            case DRAW4:
                break;

            case REVERSE:
                cur-=1;
                break;

            case SKIP:
                cur+=2;
                break;

            case WILDCARD:
                break;

            case NONE:
                cur++;
                break;

        }
        return cur;
    }
}
