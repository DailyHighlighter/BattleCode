package battleCode;





public abstract class Equipment
{
    protected int strengthModifier;
    protected int agilityModifier;
    protected int healthModifier;
    private int staminaModifier;

    protected String name;

    public Equipment()
    {
        this.strengthModifier = 0;
        this.agilityModifier = 0;
        this.healthModifier = 0;
        this.staminaModifier = 0;
        this.name = "Equipment";
    }

    public Equipment(String name)
    {
        this.strengthModifier = 0;
        this.agilityModifier = 0;
        this.healthModifier = 0;
        this.staminaModifier = 0;
        this.name = name;
    }

    public Equipment(String name, int strengthModifier, int agilityModifier, int healthModifier, int staminaModifier)
    {
        this.strengthModifier = strengthModifier;
        this.agilityModifier = agilityModifier;
        this.healthModifier = healthModifier;
        this.staminaModifier = staminaModifier ;
        this.name = name;
    }

    public int getStrengthModifier()
    {
        return strengthModifier;
    }

    public void setStrengthModifier(int strengthModifier)
    {
        this.strengthModifier = strengthModifier;
    }

    public int getAgilityModifier()
    {
        return agilityModifier;
    }

    public void setAgilityModifier(int agilityModifier)
    {
        this.agilityModifier = agilityModifier;
    }

    public int getHealthModifier()
    {
        return healthModifier;
    }

    public void setHealthModifier(int healthModifier)
    {
        this.healthModifier = healthModifier;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getStaminaModifier()
    {
        return staminaModifier;
    }

    public void setStaminaModifier(int staminaModifier)
    {
        this.staminaModifier = staminaModifier;
    }


}