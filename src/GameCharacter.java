public class GameCharacter {
    //Class Variables
    private String name;
    private String characterClass;
    private int level;
    private int health;
    private int attackPower;
    private int gold;

    // Constructor
    public GameCharacter(String name, String characterClass, int level, int health, int attackPower, int gold) {
        this.name = name;
        this.characterClass = characterClass;
        this.level = level;
        this.health = health;
        this.attackPower = attackPower;
        this.gold = gold;
    }

    //Accessor Methods
    public String getName() {
        return name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public int getGold() {
        return gold;
    }

    //ToString() Override
    @Override
    public String toString() {
        return name + " | " +
                characterClass + " | Level: " +
                level + " | Health: " +
                health + " | Attack: " +
                attackPower + " | Gold: " +
                gold;
    }
}