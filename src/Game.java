import cards.Card;
import enums.Effect;

import java.util.LinkedList;
import java.util.Stack;

public class Game {
    LinkedList<Player> sequence = new LinkedList<Player>();
    Stack<Card> drawDeck = new Stack<Card>();
    Stack<Card> discardDeck = new Stack<Card>();

    public void start(){

    }

    public void play(Player player, Card card){
        if(discardDeck.isEmpty()){
            discardDeck.push(card);
        }
        else{
            Card top = discardDeck.peek();
            card = player.chooseCard(card);
            if (card!=null){
                playCard(card, top, player);
            }
            else{
                Card newCard = drawDeck.pop();
                player.addCard(newCard);
            }
        }

    }

    public void playOptions(){

    }

    public int effectHandler(Card card, LinkedList<Player> sequence, Player player ){
        Effect effect = card.getEffect();
        int cur = sequence.indexOf(player);

        switch (effect){
            case DRAW2:
                drawDeck.push(card);
                break;
            case DRAW4:
                discardDeck.push(card);
                break;
            case REVERSE:
                drawDeck.push(card);
                break;
            case SKIP:
                discardDeck.push(card);
                break;
            case WILDCARD:

                break;
            case NONE:
                cur++;
                break;

        }

        return cur;
    }

    public void playCard(Card card, Card top, Player player){
        if (card.canPlay(top)){
            discardDeck.push(card);
            card.applyEffect(sequence);
            player.removeCard(card);
        }

    }

}

