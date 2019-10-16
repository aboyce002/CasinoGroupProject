package casino;

public class Card {
    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String suit;
    private String rank;

    public Card(int suit, int rank) {
        this.suit = suits[suit];
        this.rank = ranks[rank];
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String[] getSuits() {
        return suits;
    }

    public String[] getRanks() {
        return ranks;
    }

    @Override
    public String toString() {
        return (rank + " of " + suit);
    }
}
