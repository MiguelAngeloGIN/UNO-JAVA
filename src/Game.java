import cards.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Game {
    LinkedList<Player> sequence = new LinkedList<Player>();
    Stack<Card> drawDeck = new Stack<Card>();
    Stack<Card> discardDeck = new Stack<Card>();


    Deck deck = new Deck();



    public void drawEffect(int total, Card card, Player player,
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

    public void zeroEffect(int cur) {
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

