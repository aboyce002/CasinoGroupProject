package casino;

import java.util.*;

public class GoFish {
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
                System.out.println("It is " + playerList.get(i).getUserName() + "'s turn. Who do you want to ask for cards from?");
                String askedName = input.nextLine();
                Player askedPlayer = getPlayer(input, askedName);

                System.out.println("What suit do you want to ask for? ");
                String askedRank = input.nextLine();
                askedRank = getHand(input, askedRank);

                boolean keepFishing = fish(playerList.get(i), askedPlayer, askedRank);
                ArrayList<Card> checkHand;
                String getBook;

                while(keepFishing){
                    askedPlayer = getPlayer(input, askedName);
                    System.out.println(playerList.get(0).getHand());
                    askedRank = getHand(input, askedRank);

                    keepFishing = fish(playerList.get(i), askedPlayer, askedRank);
                    checkHand = playerList.get(i).getHand();
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
            if(askedPlayer == null)
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
        System.out.println("Yo " + asked.getUserName() + " gimme your " + rank + "s.");
        int size = asking.getHand().size();
        ArrayList<Card> gimme = new ArrayList<Card>();

        for(Card c : asked.getHand()){
            if(c.getRank().equalsIgnoreCase(rank)){
                gimme.add(c);
            }
        }
        asked.getHand().removeAll(gimme);
        asking.getHand().addAll(gimme);

        if (asked.getHand().size() == size){
            System.out.println("Go fish.");
            return false;
        }
        System.out.println(asked.getHand());
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
