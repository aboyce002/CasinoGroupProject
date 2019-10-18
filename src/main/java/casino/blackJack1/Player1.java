package casino.blackJack1;

import casino.Player;

public class Player1 {
    private String name;
    private Card1[] hand = new Card1[10];
    private int numCards;

    public Player1(String aName) {
        this.name = aName;

        // set a player's hand to empty
        this.emptyHand();
    }
    public void emptyHand(){
        for (int c = 0; c < 10; c++) {
            this.hand[c] = null;
        }
        this.numCards = 0;
    }

    /**
     * add a card to the player's hand
     *
     * @param aCard1 the card to add
     * @return whether the sum of the new hand is below or equal to 21
     */
    public boolean addCard(Card1 aCard1){
        // print err0r of we already have the max num of cards
        if (this.numCards == 10) {
            System.err.printf("%s's hand already has 10 cards; " + "cannot add another\n",  this.name);
            System.exit(1);
        }
        // add a new card in next slot and increment number of cards counter
        this.hand[this.numCards] = aCard1;
        this.numCards++;

        return (this.getHandSum() <= 21);
    }
    /**
     * Get the sum of the cards in the players hand
     *
     * @return the sum
     */
    public int getHandSum() {
        int handSum = 0;
        int cardNum;
        int numAces = 0;

        // calc each card's contribution to the hand sum
        for (int c  = 0; c < this.numCards; c++) {
            // get the number for the current card
            cardNum = this.hand[c].getNumber();

            if (cardNum == 1) { // Ace card
                numAces++;
                handSum += 11;
            } else if (cardNum > 10) { // Face card
                handSum += 10;
            } else {
                handSum += cardNum;
            }
        }
        // if we have aces and our sum is > 21, set some/all of them to value 1
        // instead
        while(handSum > 21 && numAces > 0) {
            handSum -= 10;
            numAces--;
        }

        return handSum;
    }

    /**
     * Print the cards in the player's hand
     *
     * @param showFirstCard whether the first card is hidden or not
     */
    public void printHand(boolean showFirstCard) {
        System.out.printf("%s's cards:\n", this.name);
        for (int c = 0; c < numCards; c++) {
            if (c == 0 && !showFirstCard) {
                System.out.println(" [hidden]");
            } else {
                System.out.println(this.hand[c].toString());
            }
        }
    }
}
