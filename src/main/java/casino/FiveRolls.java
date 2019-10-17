package casino;

import java.util.Scanner;

public class FiveRolls {

    //first player places a wager
    //the first player then rolls 5 times
    //if they roll an even number at least 3 times they win
    //if less than three numbers are rolled they lose
    //winner is then paid by the other players

    public double wage = 0;

    public double wage() {
        Scanner input = new Scanner(System.in);
        System.out.println("You have $" + totalMoney + " How much do you want to wage?");
        double thisWage = input.nextDouble();
        while (thisWage > totalMoney) {
            System.out.println("You don't have that much money broke boi");
            thisWage = input.nextDouble();
        }
        totalMoney -= wage;
        return thisWage;
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        System.out.println("How much do you want to put down?");
        String bet = input.nextLine();
        double wage = wage();
    }

    public void fiveRolls() {

        int counter = 0;
        int evensCounter = 0;
        double wage = 0;

        while ((counter != 5) || (evensCounter != 3)) {

            int targetNumber = (int) (Math.random() * 6);
            System.out.println("This is the one right here");

            if (targetNumber % 2 == 0) {
                System.out.println("Player has to get an even" + (3 - counter) + " more times.");
                evensCounter++;
            } else {
                System.out.println("Roll again sucka!");

                if (evensCounter == 3) {
                    System.out.println("You have won the game and your original bet has been doubled!" + wage * 2);
                }

                counter++;
            }
        }
    }
}



