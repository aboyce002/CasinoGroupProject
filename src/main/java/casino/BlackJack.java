package casino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack implements Game {
    private List<Player> players = new ArrayList<Player>();

    public BlackJack() {
    }

    public void play() {
        System.out.println("   \n" + "   \n" + "  \n" + "  \n");
        Scanner scanner = new Scanner(System.in);
        BlackJack game = new BlackJack();
        players.add(new Player("Todd", 400.00));
        players.add(new Player("Blake", 350.00));
        players.add(new Player("Dale", 50.00));
        players.add(new Player("Jay", 150.00));

        System.out.println("Welcome to BlackJack ");
        scanner.nextLine();




        Player dealer = new Player("Dealer", 500.00);
        dealer.getHand();
        for(int x = 0; x < players.size(); x++)

        if(dealerLoseByDefault){
                game.lostByDefault(scanner);
            }

            Player winner = game.guessWinner(game.players, dealer);
        System.out.println(user +"'s total is: "+user.getTotal()+".\n"+dealer +
                    "'s total is: "+dealer.getTotal()+".\n");
        System.out.println("%s WIN!\n\n",winner);




    public Player playerTurn(Player dealer, Player user) {
        return dealer;
    }

}
