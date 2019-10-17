package casino;

import java.util.*;

public class Casino {
    public static void main(String[] args) {
        Deck aaa = new Deck();
        List<Card> hand = new ArrayList<Card>();

        int card = (int)(Math.random() * aaa.cardsLeft());
        System.out.println(aaa.getCard());
        aaa.displayDeck();
        aaa.shuffle();
        aaa.displayDeck();

        hand.add(aaa.getCard());
        System.out.println(hand);
        System.out.println(aaa.getCard());

        BlackJack blackjack = new BlackJack();
        blackjack.play();
    }
}
