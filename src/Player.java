import cards.Card;

import java.util.ArrayList;

public class Player {
    private final String name;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Card> playableCards = new ArrayList<Card>();

    Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards(){
        return new ArrayList<>(cards);
    }

    public ArrayList<Card> getPlayableCards(){
        return new ArrayList<>(this.playableCards);
    }

    public Card chooseCard(Card card){
        if(this.cards.contains(card)){
            return card;
        }
        return null;
    }

    public void removeCard(Card card){
        this.cards.remove(card);
    }

    public void addCard(Card card){
        this.cards.add(card);
    }
}

