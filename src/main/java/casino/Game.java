package casino;

public interface Game {
    void play();
    void deal();

    Player playerTurn(Player dealer, Player user);
}
