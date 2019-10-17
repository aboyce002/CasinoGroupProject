package casino;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String userName;
    private double amountOfMoney;
    private ArrayList<Deck> hand;

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

    public ArrayList<Deck> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Deck> hand) {
        this.hand = hand;
    }
}
