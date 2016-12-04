package battlecode;

public abstract class Hero {

    private int health;
    private int agility;
    private int strength;
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    public Hero(int agility, int strength, String name) {
        this.agility = agility;
        this.strength = strength;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addHealth(int healthToAdd) {
        if (healthToAdd >= 0) {
            this.health += healthToAdd;
        }
    }

    public void removeHealth(int healthToRemove) {
        if (healthToRemove >= 0) {
            this.health -= healthToRemove;
        }
    }

    public void printStats() {
        System.out.println("");
        System.out.println(this.name.toUpperCase() + "'S STATS");
        System.out.println("-------------------------");
        System.out.println(name + "'s Strength: " + this.strength);
        System.out.println(name + "'s Agility: " + this.agility);
        System.out.println(name + "'s Health: " + this.health);
    }

    public int attack() {
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        int attackValue = this.strength + die1.roll() + die2.roll();

        return attackValue;
    }

    public int block() {
        int doubleValue; //value to be returned
        Die die1 = new Die(10);
        int die1Value = die1.roll();
        if (die1Value < 4) {
            doubleValue = (die1Value * 2) + this.agility;
        } else {
            doubleValue = die1Value + this.agility;
        }
        return doubleValue;

    }

    public int rest() {
        Die die1 = new Die(8);
        Die die2 = new Die(8);

        int sum = die1.roll() + die2.roll();
        this.health += sum;
        return sum;
    }

}
