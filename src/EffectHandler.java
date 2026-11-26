import cards.Card;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class EffectHandler {
    public void drawEffect(int total, Player player,
                           Stack<Card> drawDeck) {
        for (int i = 0; i < total; i++) {
            Card drawnCard = drawDeck.pop();
            player.addCard(drawnCard);

        }
    }

    public int revertEffect(int cur) {
        return cur-1;
    }

    public int skipEffect(int cur) {
        return cur+=2;
    }

    public void zeroEffect(LinkedList<Player> sequence) {
        ArrayList <ArrayList<Card>> temp = new ArrayList<>();

        for (Player player : sequence) {
            temp.add(player.copyCards());
            player.clearCards();
        }
        for (int i = temp.size()-1; i >= 0 ; i--) {
            Player player = sequence.get(i);
            for (Card card : temp.get((i-1 + temp.size())%temp.size())) {
                player.addCard(card);
            }
        }
    }
}
