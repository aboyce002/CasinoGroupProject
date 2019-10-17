package casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GoFish {
    private Deck deck = new Deck();
    private int players;

    public void play(){
        //add players
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Go Fish. How many players are there? Max 5 people per game.");
        int playerCount = input.nextInt();
        if(playerCount <= 5)
            players = playerCount;
        String bet = input.nextLine();

        List<ArrayList> aaa = new ArrayList<ArrayList>();

        aaa.add(new ArrayList<Card>());
        aaa.add(new ArrayList<Card>());
        aaa.add(new ArrayList<Card>());
        aaa.add(new ArrayList<Card>());
        aaa.add(new ArrayList<Card>());

        deck.shuffle();

        for(int i = 0; i < players; i++){
            for(int x = 0; x < 7; x++){
                aaa.get(i).add(deck.getCard());
            }
        }

        System.out.println(Arrays.toString(aaa.get(0).toArray()));
    }
}
