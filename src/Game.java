import cards.*;
import enums.Color;
import enums.Effect;

import java.util.LinkedList;
import java.util.Stack;

public class Game {
    LinkedList<Player> sequence = new LinkedList<Player>();
    Stack<Card> drawDeck = new Stack<Card>();
    Stack<Card> discardDeck = new Stack<Card>();


    Deck deck = new Deck();













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




    public void playCard(Card card, Card top, Player player){
        if (card.canPlay(top)){
            discardDeck.push(card);
            player.removeCard(card);
        }

    }

}

