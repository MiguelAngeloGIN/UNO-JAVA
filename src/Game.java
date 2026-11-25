import cards.*;
import enums.Color;
import enums.Effect;

import java.util.LinkedList;
import java.util.Stack;

public class Game {
    LinkedList<Player> sequence = new LinkedList<Player>();
    Stack<Card> drawDeck = new Stack<Card>();
    Stack<Card> discardDeck = new Stack<Card>();


    public void createCards(){
        createRegularCards();
        createRegularCards();
        createColorlessCards();
        createColoredCards();
        createColoredCards();
    }

    public void createRegularCards(){
        for(int i=1; i<10; i++){
            for(Color color: Color.values()){
                Card card = new Regular(color, String.valueOf(i));
                drawDeck.push(card);
            }
        }
    }

    public void createColorlessCards(){
        for (int i=0; i<4; i++){
             Card wildcard = new WildCard();
             drawDeck.push(wildcard);
             Card draw4 = new Draw4();
             drawDeck.push(draw4);
        }
    }


    public void createColoredCards(){
        for(Color color : Color.values()){
            Card zero = new Zero(color);
            drawDeck.push(zero);
            Card reverse = new Reverse(color);
            drawDeck.push(reverse);
            Card skip = new Skip(color);
            drawDeck.push(skip);
            Card draw2 = new Draw2(color);
            drawDeck.push(draw2);
        }
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
            player.removeCard(card);
        }

    }

}

