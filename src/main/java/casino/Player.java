package casino;

import java.util.ArrayList;

public class Player {
    private String userName;
    private double amountOfMoney;
    private Deck hand;

    public Player(String userName, double amountOfMoney){
        this.userName = userName;
        this.amountOfMoney = amountOfMoney;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
  
    public Deck getHand() {
        return hand;
    }

    public void setHand(Deck hand) {
        this.hand = hand;
    }
}
