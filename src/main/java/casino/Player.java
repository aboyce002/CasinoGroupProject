package casino;

import java.util.ArrayList;

public class Player {
    private String userName;
    private double amountOfMoney;
    private ArrayList<Card> hand;

    public Player(String userName, double amountOfMoney){
        this.userName = userName;
        this.amountOfMoney = amountOfMoney;
        this.hand = new ArrayList<Card>();
    }

    public String getUserName() {
        return userName;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
}
