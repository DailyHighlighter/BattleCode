package battlecode;

import java.util.Random;

public class Die {

    private int sides;
    private int value;
    Random r = new Random();

    public Die() {
        sides = 1;
        value = 1;
    }

    public Die(int numOfSides) {
        if (numOfSides <= 0) {
            sides = 1;
            value = 1;
        } else {
            sides = numOfSides;
            value = 1;
        }
    }

    public int roll() {
        value = r.nextInt(sides) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int s) {
        sides = s;
    }
}
