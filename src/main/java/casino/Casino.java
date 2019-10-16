package casino;

<<<<<<< HEAD
public class Casino {
    public static void main(String[] args) {
        // write your tests before you start fucking with this
=======
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
>>>>>>> 51363f6a00c25fef6657bf57a8ef07c0b0b9f7a1
    }
}
