package casino;

import java.util.*;

public class GoFish implements Game implements CardGame {
    private Deck deck = new Deck();
    private List<Player> playerList = new ArrayList<Player>();
    private int bookCount = 0;
    private Player winner = null;

    public void play(){
        List<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        playerList.add(new Player("Bob", 1340.0));
        playerList.add(new Player("Sally", 12683.0));
        playerList.add(new Player("Jared", 27246.0));
        playerList.add(new Player("Bill", 5831.0));

        for(int i = 0; i < playerList.size(); i++)
        {
            books.add(new ArrayList<String>());
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Go Fish. " + playerList.get(0).getUserName() + " will take the first turn.");

        deck.shuffle();
        deal();

        while(winner == null){
            for(int i = 0; i < playerList.size(); i++) {
                Player asking = playerList.get(i);

                if(asking.getHand().size() == 0 && deck.cardsLeft() != 0){
                    System.out.println(asking.getUserName() + " has no cards left. Drawing a card from the deck.");
                    asking.getHand().add(deck.getCard());
                }
                else if (asking.getHand().size() == 0 && deck.cardsLeft() == 0){
                    System.out.println(asking.getUserName() + " has no more cards and is out of the game. Skipping.");
                    i++;
                }

                String askedName = "";
                String askedRank = "";
                Player askedPlayer;
                boolean keepFishing = true;
                ArrayList<Card> checkHand;
                String getBook;

                while(keepFishing){
                    System.out.println("It is " + asking.getUserName() + "'s turn. Who do you want to ask for cards from?");
                    askedName = input.nextLine();
                    askedPlayer = getPlayer(input, askedName);
                    System.out.println("What suit do you want to ask for? ");
                    askedRank = input.nextLine();
                    askedRank = getHand(input, askedRank);

                    keepFishing = fish(asking, askedPlayer, askedRank);

                    checkHand = asking.getHand();
                    getBook = checkBook(checkHand, books.get(i));
                    if(getBook != null)
                        books.get(i).add(getBook);
                }

                if(bookCount == 13)
                    winner = checkWin(books);

                if ((i + 1 % playerList.size() == 0))
                    i = -1;
            }
        }
    }

    private Player getPlayer(Scanner s, String name){
        Player askedPlayer = null;

        while(askedPlayer == null) {
            for (Player p : playerList) {
                if ((p.getUserName().equalsIgnoreCase(name))) {
                    askedPlayer = p;
                }
            }
            if(askedPlayer == null || askedPlayer.getHand().isEmpty())
            {
                System.out.println("Please enter a valid name.");
                name = s.nextLine();
            }
        }
        return askedPlayer;
    }

    private String getHand(Scanner s, String rank){
        Card c = new Card(1, 1);
        String[] rankList = c.getRanks();

        while(c != null){
            for (String value : rankList) {
                if (!(value.equalsIgnoreCase(rank))) {
                    c = null;
                    break;
                }
            }
            if(c != null)
            {
                System.out.println("Please enter a valid rank.");
                rank = s.nextLine();
            }
        }
        return rank;
    }

    private boolean fish(Player asking, Player asked, String rank){
        if (rank.matches("-?\\d+") || rank.equalsIgnoreCase("ace")) {
            System.out.println("Yo " + asked.getUserName() + " gimme your " + rank + "s.");
        }
        else {
            System.out.println("Yo " + asked.getUserName() + " gimme your " + rank + ".");
        }

        int size = asked.getHand().size();
        ArrayList<Card> gimme = new ArrayList<Card>();

        for(Card c : asked.getHand()){
            if(c.getRank().equalsIgnoreCase(rank)){
                System.out.println("Here is a " + c + ".");
                gimme.add(c);
            }
        }
        asked.getHand().removeAll(gimme);
        asking.getHand().addAll(gimme);

        System.out.println(asking.getHand());
        System.out.println(asked.getHand());

        if (asked.getHand().size() == size){
            System.out.println("Go fish.");
            return false;
        }
            return true;
    }

    private String checkBook(ArrayList<Card> currentPlayerHand, ArrayList<String> currentPlayerBooks){
        String currentRank;
        int currentRankCount = 0;

        for(Card c : currentPlayerHand){
            currentRank = c.getRank();
            for(Card card : currentPlayerHand){
                if (card.getRank().equals(currentRank))
                    currentRankCount++;
            }
            if(currentRankCount == 4){
                bookCount++;
                currentPlayerBooks.add(currentRank);
                return currentRank;
            }
        }
        return null;
    }

    private Player checkWin(List<ArrayList<String>> b){
        Player winner = null;
        int currentBookCount = 0;
        int highestBooks = 0;
        for(int i = 0; i < playerList.size(); i++){
            ArrayList<String> currentPlayerBook = b.get(i);

            for(int x = 0; x < currentPlayerBook.size(); x++)
                currentBookCount++;

            if (currentBookCount > highestBooks){
                highestBooks = currentBookCount;
                winner = playerList.get(i);
            }
        }
        return winner;
    }

    private void deal(){
        int dealSize = 7;
        if (playerList.size() > 3)
           dealSize = 5;
        for (Player player : playerList) {
            for (int x = 0; x < dealSize; x++) {
                player.getHand().add(deck.getCard());
            }
        }
        System.out.println(playerList.get(0).getHand());
    }
}