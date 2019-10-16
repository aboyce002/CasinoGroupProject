package casino;

public class FiveRolls {

    //first player places a wager
    //the first player then rolls 5 times
    //if they roll an even number at least 3 times they win
    //if less than three numbers are rolled they lose
    //winner is then paid by the other players

    public void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int targetNumber = (int) (Math.random() * 6);
        System.out.println("This is the one right here");

        if (targetNumber % 2 == 0)
            System.out.println("Player has to get an even two more times");
        else
            System.out.println("Roll again sucka!");
    }
}
