package casino.blackJack1;

import casino.Deck;

import java.util.Random;

public class Deck1 {
    /**
     * the number of cards currently in the deck
     */
    private Card1[] myCards;
    private int numCards;

    /**
     *
     */
    public Deck1() {

    }
    /**
     * Constructor that defines the number of decks (i.e., how many sets of 52
     * cards are in the deck) and whether it should be shuffled
     *
     * @param numDecks the number of the individual decks in the deck
     * @param shuffle whether to shuffle the cards
     */

    public Deck1(int numDecks, boolean shuffle){


        this.numCards = numDecks * 52;
        this.myCards = new Card1[this.numCards];
        // init card index
        int c = 0;
        // for each deck
        for (int d = 0; d < numDecks; d++){
            //for each number
            for(int s = 0; s < 4; s++){
                //for each number
                for (int n = 1; n<= 13; n++){
                    // add a new card to the deck
                    this.myCards[c] = new Card1(Suit.values()[s], n);
                    c++;
                }
            }
        }
        // shuffle if necessary
        if (shuffle) {
            this.shuffleOne();
        }
    }

    public void shuffleOne() {
        // init random number generator
        Random rng = new Random();
        // temporary cord
        Card1 temp;

        int j;
        for (int i = 0; i < numCards; i++) {
            // get a random card j to swap i's value with
            j = rng.nextInt(this.numCards);
            // do swap
            temp = this.myCards[i];
            this.myCards[j] = temp;

        }
    }

    public Card1 dealNextCard() {
        // get a card
        Card1 top = this.myCards[0];

        // shift all the subsequent cards to the left by one index
        for (int c = 1; c < this.numCards; c++){
            this.myCards[c-1] = this.myCards[c];
        }
        this.myCards[this.numCards - 1] = null;
        // decrement the number of cards in our deck
        this.numCards--;

        return top;
    }
    public void printDeck(int numToPrint) {
        for (int c = 0; c < numToPrint; c++){
            System.out.printf("% 3d/%d %s\n", c+1, this.numCards,
                    this.myCards[c].toString());
        }
        System.out.printf("\t[%d others]\n", this.numCards-numToPrint);
    }
}
