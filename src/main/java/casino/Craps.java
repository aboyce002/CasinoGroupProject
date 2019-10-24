package casino;

import java.util.*;

public class Craps implements GamblingGame{
    private int dice1;
    private int dice2;
    private int sum;
    private int point;

    private double totalMoney = 10000;
    private double wage = 0;

    public void play(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Craps. You have $" + totalMoney + ".");
        wage = wage();
        pass();
    }

    private void pass(){
        roll();
        System.out.println("You rolled a " + sum);

        if(sum == 7 || sum == 11){
            wage *= 2;
            totalMoney += wage;
            System.out.println("You won! Your wage is doubled and is now $" + wage);
        }
        else if (sum == 2 || sum == 3 || sum == 12){
            wage = 0;
            System.out.println("You lost your wage.");
        }
        else{
            point = sum;
            System.out.println("The Point is now " + point + ".");
            while((point != 0)){
                roll();
                System.out.println("You rolled a " + sum);

                if(sum == 7)
                {
                    point = 0;
                    wage = 0;
                    System.out.println("You lost your wage.");
                }
                else if (sum == point){
                    point = 0;
                    wage *= 2;
                    totalMoney += wage;
                    System.out.println("You won! Your wage is doubled and is now $" + wage);
                }
            }
        }
    }

    private void doNotPass(){
        roll();
        System.out.println("You rolled a " + sum);

        if(sum == 2 || sum == 3){
            wage *= 2;
            totalMoney += wage;
            System.out.println("You won! Your wage is doubled and is now $" + wage);
        }
        else if (sum == 7 || sum == 11){
            wage = 0;
            System.out.println("You lost your wage.");
        }
        else if (sum == 12){
            totalMoney += wage;
            System.out.println("Pass.");
        }
        else{
            point = sum;
            System.out.println("The Point is now " + point + ".");
            while((point != 0)){
                roll();
                System.out.println("You rolled a " + sum);

                if(sum == point)
                {
                    point = 0;
                    wage = 0;
                    System.out.println("You lost your wage.");
                }
                else if (sum == 7){
                    point = 0;
                    wage *= 2;
                    totalMoney += wage;
                    System.out.println("You won! Your wage is doubled and is now $" + wage);
                }
            }
        }
    }

    private void roll(){
        dice1 = (int)((Math.random()*6)+1);
        dice2 = (int)((Math.random()*6)+1);
        sum = dice1 + dice2;
    }

    public double wage(){
        Scanner input = new Scanner(System.in);
        System.out.println("You have $" + totalMoney + ". How much would you like to wage? ");
        double thisWage =  input.nextDouble();
            while(thisWage > totalMoney) {
                System.out.println("You do not have that much money ):<");
                thisWage = input.nextDouble();
            }
            totalMoney -= wage;
        return thisWage;
    }
}
