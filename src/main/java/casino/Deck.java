package casino;
import java.util.*;

public class Deck {
    private int deckSize = 52;
    private List<Card> deck = new ArrayList<Card>();

    //initialize with one pack/52 cards
    public Deck(){ addCards(); }

    //option to initialize with multiple packs of cards for games like Blackjack
    public Deck(int x) {
        for(int i = 0; i < x; i++)
            addCards();
        deckSize = x * 52;
    }

    //add every type of card to the deck
    private void addCards(){
        for(int suit = 0; suit <= 3; suit++){
            for(int rank = 0; rank <= 12; rank++){
                deck.add(new Card(suit, rank));
            }
        }
    }

    //adds to the *top* of the deck
    public void addTop(Card c){
        deck.add(c);
    }

    //adds to the *bottom* of the deck
    public void addBottom(Card c){
        deck.add(0, c);
    }

    //get count
    public int cardsLeft(){
        return deck.size();
    }

    //use for testing
    public void displayDeck(){
        for(Card d : deck){
            System.out.println(d);
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card getCard(){
        return deck.remove(deck.size()-1);
    }

    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
}
