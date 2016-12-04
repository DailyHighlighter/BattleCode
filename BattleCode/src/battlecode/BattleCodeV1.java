package battlecode;

import java.util.Scanner;

public class BattleCodeV1 {

    public static void main(String[] args) {
        String MenuSwitch;
        Scanner scnr = new Scanner(System.in);
        Die die1 = new Die(8);
        Die die2 = new Die(8);
        System.out.println("WELCOME TO THE BATTLE ARENA");
//        System.out.println("\n");
        System.out.println("\nIf you would like to play, type play");
        System.out.println("Play: Start the Game");
        System.out.println("Exit: Leave the fun behind");
        MenuSwitch = scnr.nextLine();
        switch (MenuSwitch) {
            case "play":
                System.out.print("\n \n \n \n \n \n \n \n \n");

                System.out.println("Hey, Welcome to Martin's Battle Arena, Would you like to play");
                System.out.println("What is the first player's name? ");
                String hero1Name = scnr.next();
                System.out.println("What is the second player's name? ");
                String hero2Name = scnr.next();
                System.out.println("How many rounds will they be fighting for, my dude? ");
                int rounds = scnr.nextInt();

                Hero hero1 = new Hero(hero1Name);
                Hero hero2 = new Hero(hero2Name);
                Hero winner;

                BattleManager managerBro = new BattleManager();

                winner = managerBro.battle(hero1, hero2, rounds);

                System.out.println("\n" + winner.getName() + " is the Winner!");
                break;
            case "exit":
                break;
//            case "":    
            default:
                System.out.println("Invalid Selection, try Again");

        }
    }

}
