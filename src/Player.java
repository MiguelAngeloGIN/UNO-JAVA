import cards.Card;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final ArrayList<Card> cards = new ArrayList<Card>();
    private final ArrayList<Card> playableCards = new ArrayList<Card>();

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

    public void clearCards(){
        cards.clear();
    }


    public void hasPlayableCards(Card top) {
        playableCards.clear();
        for(Card card : this.cards){
            if (card.canPlay(top)){
                playableCards.add(card);
            }
        }
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

    public ArrayList<Card> copyCards() {
        return new ArrayList<>(cards);
    }
}

