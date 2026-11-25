import cards.Card;
import enums.Effect;
import java.util.ArrayList;
import java.util.Stack;

public class EffectHandler {

    public static void effectHandler(Card card, Player player,
                                    ArrayList<Player> sequence,
                                    Stack<Card> drawDeck) {
        /*
           Reverse and Skip are handled entirely in Game
           because they only affect turn progression.
         */

        Effect effect = card.getEffect();

        switch (effect){
            case DRAW2:
                for (int i = 1; i < 3; i++) {
                    Card drawnCard = drawDeck.pop();
                    player.addCard(drawnCard);
                }
                break;

            case DRAW4:

                for (int i = 1; i < 5; i++) {
                    Card drawnCard = drawDeck.pop();
                    player.addCard(drawnCard);
                }
                break;




        }
    }
}
