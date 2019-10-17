package casino;

public interface Game {
    void play();

    Player playerTurn(Player dealer, Player user);
}
