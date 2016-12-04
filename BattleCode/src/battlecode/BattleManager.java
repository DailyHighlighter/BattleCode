package battlecode;

import java.util.Arrays;
import java.util.Scanner;

public class BattleManager {

    Scanner scnr = new Scanner(System.in);

    private void setStrengthAgility(Hero myHero) {
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        Die die3 = new Die(6);
        int value1 = die1.roll();
        int value2 = die2.roll();
        int value3 = die3.roll();
        int[] values = new int[]{value1, value2, value3};
        Arrays.sort(values);
        int strengh = values[values.length - 1];
        int agility = values[values.length - 2];
        myHero.setStrength(strengh);
        myHero.setAgility(agility);

    }

    private int selectMove(Hero hero1) {
        System.out.println(hero1.getName() + " , select a move to make by entering option 1 or option 2 or option 3");
        System.out.println("\n  1 is attack" + "\n  2 is block an attack" + "\n  3 is rest to restore health");
        int playerChoice = scnr.nextInt();
        return playerChoice;
    }

    private void fight(Hero hero1, Hero hero2) {
        int move1;
        int move2;
        int fight1;
        int fight2;
        int block1;
        int block2;
        int valueAfterBlocking;
        move1 = this.selectMove(hero1);
        move2 = this.selectMove(hero2);

        if (move1 == 1 && move2 == 1) {
            System.out.println(hero1.getName() + " is attacking " + hero2.getName());
            fight1 = hero1.attack();
            System.out.println(hero2.getName() + " is attacking " + hero1.getName());
            fight2 = hero2.attack();
            hero1.removeHealth(fight2);
            hero2.removeHealth(fight1);
        } else if (move1 == 1 && move2 == 2) {
            System.out.println(hero1.getName() + " has attacked " + hero2.getName());
            fight1 = hero1.attack();
            System.out.println(hero2.getName() + " has blocked " + hero2.getName() + "'s attack");
            block2 = hero2.block();
            valueAfterBlocking = fight1 - block2;
            if (valueAfterBlocking > 0) {
                hero2.removeHealth(valueAfterBlocking);
            }

        } else if (move1 == 1 && move2 == 3) {
            System.out.println(hero1.getName() + " is attacking " + hero2.getName());
            fight1 = hero1.attack();
            System.out.println(hero2.getName() + " is restoring their health");
            int restValue2 = hero2.rest();
            if ((hero2.getHealth() + restValue2) >= 100) {
                hero2.setHealth(100);
            }

            hero2.removeHealth(fight1);
        } else if (move1 == 2 && move2 == 1) {
            System.out.println(hero1.getName() + " has blocked " + hero2.getName() + "'s attack");
            block1 = hero1.block();
            System.out.println(hero2.getName() + " is attacking " + hero2.getName());
            fight2 = hero2.attack();
            valueAfterBlocking = fight2 - block1;
            if (valueAfterBlocking > 0) {
                hero1.removeHealth(valueAfterBlocking);
            }
        } else if (move1 == 2 && move2 == 2) {
            System.out.println(hero1.getName() + " has blocked " + hero2.getName());
            hero1.block();
            System.out.println(hero2.getName() + " has blocked " + hero1.getName());
            hero2.block();
        } else if (move1 == 2 && move2 == 3) {
            System.out.println(hero1.getName() + " has moved to block an attack");
            hero1.block();
            System.out.println(hero2.getName() + " is restoring their health");
            int restValue2 = hero2.rest();
            if ((hero2.getHealth() + restValue2) >= 100) {
                hero2.setHealth(100);
            }
        } else if (move1 == 3 && move2 == 1) {
            System.out.println(hero1.getName() + " is restoring their health");
            int restValue1 = hero1.rest();
            if ((hero1.getHealth() + restValue1) >= 100) {
                hero1.setHealth(100);
            }
            System.out.println(hero2.getName() + " has blocked an attack");
            fight2 = hero2.attack();
            hero1.removeHealth(fight2);
        } else if (move1 == 3 && move2 == 2) {
            System.out.println(hero1.getName() + " is restoring their health");
            int restValue1 = hero1.rest();
            if ((hero1.getHealth() + restValue1) >= 100) {
                hero1.setHealth(100);
            }
            System.out.println(hero2.getName() + " is blocking attacks");
            hero2.block();
        } else if (move1 == 3 && move2 == 3) {
            System.out.println(hero1.getName() + " is restoring their health");
            int restValue1 = hero1.rest();
            if ((hero1.getHealth() + restValue1) >= 100) {
                hero1.setHealth(100);
            }
            System.out.println(hero2.getName() + " is restoring their health");
            int restValue2 = hero2.rest();
            if ((hero2.getHealth() + restValue2) >= 100) {
                hero2.setHealth(100);
            }
        }
    }

    public Hero battle(Hero hero1, Hero hero2, int numOfRounds) {

        hero1.setHealth(100);
        hero2.setHealth(100);
        this.setStrengthAgility(hero1);
        this.setStrengthAgility(hero2);

        if (numOfRounds > 0) {
            for (int i = 1; i <= numOfRounds; i++) {
                System.out.println("\n<<<<<<<<>>>>>>>>>");
                System.out.println("ROUND NUMBER " + i);
                System.out.println("-------------------");
                fight(hero1, hero2);
                hero1.printStats();
                System.out.println("");
                hero2.printStats();
            }
        } else if (numOfRounds == 0) {
            int counter = 1;
            while (hero1.getHealth() > 0 && hero2.getHealth() > 0) {
                System.out.println("\n<<<<<<<<>>>>>>>>>");
                System.out.println("ROUND NUMBER " + counter);
                System.out.println("-------------------");
                fight(hero1, hero2);
                hero1.printStats();
                System.out.println("");
                hero2.printStats();
                counter++;
            }
        }

        if (hero1.getHealth() > hero2.getHealth()) {
            return hero1;
        } else {
            return hero2;
        }

    }

}
