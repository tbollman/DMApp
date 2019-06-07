import java.util.Scanner;

public class CharacterSheet {
    private Scanner keyboard = new Scanner(System.in);

    private String username;
    private String characterName;
    private String characterRace;
    private String characterClass;
    private String characterBackground;
    private int armorClass;
    private int initiative;
    private int speed;

    private Ability strength = new Ability();
    private Ability dexterity = new Ability();
    private Ability constitution = new Ability();
    private Ability intelligence = new Ability();
    private Ability wisdom = new Ability();
    private Ability charisma = new Ability();

    //  default constructor
    public CharacterSheet() {
        username = "";
        characterName = "";
        characterRace = "";
        characterClass = "";
        characterBackground = "";
        armorClass = 10;
        initiative = 0;
        speed = 30;

        strength.setAbilityScore(10);
        dexterity.setAbilityScore(10);
        constitution.setAbilityScore(10);
        intelligence.setAbilityScore(10);
        wisdom.setAbilityScore(10);
        charisma.setAbilityScore(10);
    }

    // set ability scores and get ability modifiers
    // STRENGTH
    public void setStrengthScore() {
            strength.setAbilityScore(keyboard.nextInt());
    }

    public int getStrengthScore() {
        System.out.println();
        System.out.print("STR Score: ");
        return strength.getAbilityScore();
    }

    public int getStrengthModifier() {
        System.out.println();
        System.out.print("STR Mod: ");
        return strength.getAbilityModifier();
    }

    // DEXTERITY
    public void setDexScore() {
        dexterity.setAbilityScore(keyboard.nextInt());
    }

    public int getDexScore() {
        System.out.println();
        System.out.print("DEX Score: ");
        return dexterity.getAbilityScore();
    }

    public int getDexModifier() {
        System.out.println();
        System.out.print("DEX Mod: ");
        return dexterity.getAbilityModifier();
    }

    // CONSTITUTION
    public void setConScore() {
        constitution.setAbilityScore(keyboard.nextInt());
    }

    public int getConScore() {
        System.out.println();
        System.out.print("CON Score: ");
        return constitution.getAbilityScore();
    }

    public int getConModifier() {
        System.out.println();
        System.out.print("CON Mod: ");
        return constitution.getAbilityModifier();
    }

    // INTELLIGENCE
    public void setIntScore() {
        intelligence.setAbilityScore(keyboard.nextInt());
    }

    public int getIntScore() {
        System.out.println();
        System.out.print("INT Score: ");
        return intelligence.getAbilityScore();
    }

    public int getIntModifier() {
        System.out.println();
        System.out.print("INT Mod: ");
        return intelligence.getAbilityModifier();
    }

    // WISDOM

    public void setWisScore() {
        wisdom.setAbilityScore(keyboard.nextInt());
    }

    public int getWisScore() {
        System.out.println();
        System.out.print("WIS Score: ");
        return wisdom.getAbilityScore();
    }

    public int getWisModifier() {
        System.out.println();
        System.out.print("WIS Mod: ");
        return wisdom.getAbilityModifier();
    }

    // CHARISMA

    public void setChaScore() {
        charisma.setAbilityScore(keyboard.nextInt());
    }

    public int getChaScore() {
        System.out.println();
        System.out.print("CHA Score: ");
        return charisma.getAbilityScore();
    }

    public int getChaModifier() {
        System.out.println();
        System.out.print("CHA Mod: ");
        return charisma.getAbilityModifier();
    }

    public void setAllScores() {
        System.out.print("Set Strength Score: ");
        setStrengthScore();
        System.out.println();
        System.out.print("Set Dexterity Score: ");
        setDexScore();
        System.out.println();
    }

    public void showAllScores() {
        System.out.print("Strength Score: ");
        System.out.print(getStrengthScore());
        System.out.println();
        System.out.print("Dexterity Score: ");
        System.out.print(getDexScore());
        System.out.println();
    }

    public void showAllModifiers() {
        System.out.print("Strength Mod: ");
        System.out.print(getStrengthModifier());
        System.out.println();
        System.out.print("Dexterity Mod: ");
        System.out.print(getDexModifier());
        System.out.println();
    }

    //getters and setters
    public void setCharacterName() {
        System.out.println("Enter your Character Name: ");
        this.characterName = keyboard.nextLine();
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public void setCharacterRace() {
        System.out.println("Enter your Character Race: ");
        this.characterRace = keyboard.nextLine();
    }

    public String getCharacterRace() {
        return this.characterRace;
    }

    public void setCharacterClass() {
        System.out.println("Enter your Character Class: ");
        this.characterClass = keyboard.nextLine();
    }

    public String getCharacterClass() {
        return this.characterClass;
    }

    // Character Creator Method will use all of the set methods to prompt the user to enter in their information
    public void characterCreator() {
        this.setCharacterName();
        this.setCharacterRace();
        this.setCharacterClass();
        this.setAllScores();
    }

    public void displayCharacterInfo() {
        System.out.println("Name: " + characterName);
        System.out.println("Race: " + characterRace);
        System.out.println("Class: " + characterClass);
        this.showAllScores();
        this.showAllModifiers();
    }
}
