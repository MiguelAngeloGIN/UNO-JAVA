import cards.*;
import enums.Color;
import java.util.Stack;
import java.util.Collections;

public class Deck {
    private Stack<Card> drawDeck = new Stack<Card>();
    private Stack<Card> discardDeck = new Stack<Card>();

    public Deck() {
        createCards();
        Collections.shuffle(drawDeck);
    }

    public void createCards() {
        createRegularCards();
        createRegularCards();
        createColorlessCards();
        createColoredCards();
        createColoredCards();
    }

    public void createRegularCards() {
        for (int i = 1; i < 10; i++) {
            for (Color color : Color.values()) {
                Card card = new Regular(color, String.valueOf(i));
                drawDeck.push(card);
            }
        }
    }

    public void createColorlessCards() {
        for (int i = 0; i < 4; i++) {
            Card wildcard = new WildCard();
            drawDeck.push(wildcard);
            Card draw4 = new Draw4();
            drawDeck.push(draw4);
        }
    }

    public void createColoredCards() {
        for (Color color : Color.values()) {
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

    public Card drawCard() {
       return drawDeck.pop();
    }

    public void playCard(Card card) {
        discardDeck.push(card);
    }

    public void refillDrawDeck() {
        Card top = discardDeck.pop();
        Collections.shuffle(discardDeck);

        while (!discardDeck.isEmpty()) {
            Card card =  discardDeck.pop();
            drawDeck.push(card);
        }
        discardDeck.push(top);
    }
}
