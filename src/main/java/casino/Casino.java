package casino;

import java.util.*;

public class Casino {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the casino. Which game would you like to play?\n" +
                "The games we have available are:\n" +
                "\t Go Fish" + "\n\t Blackjack" + "\n\t Craps" + "\n\t Five Rolls");
        String game = input.nextLine();

        if ("go fish".equals(game.toLowerCase())) {
            GoFish goFish = new GoFish();
            goFish.play();
        } else if ("blackjack".equals(game.toLowerCase())) {
            //BlackJack blackjack = new BlackJack();
            //blackjack.play();
        } else if ("craps".equals(game.toLowerCase())) {
            Craps craps = new Craps();
            craps.play();
        } else if ("five rolls".equals(game.toLowerCase())) {
            //FiveRolls fiveRolls = new FiveRolls();
            //fiveRolls.play();
        } else {
            System.out.println("That is not a game .-.");
        }

        /*
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
        */
    }
}
