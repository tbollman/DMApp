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

    private Skill strSave = new Skill("Strength Save", "STR");
    private Skill dexSave = new Skill("Dexterity Save", "DEX");
    private Skill conSave = new Skill("Constitution Save", "CON");
    private Skill intSave = new Skill("Intelligence Save", "INT");
    private Skill wisSave = new Skill("Wisdom Save", "WIS");
    private Skill chaSave = new Skill("Charisma Save", "CHA");

    private Skill acrobatics = new Skill("Acrobatics", "DEX");
    private Skill animalHandling = new Skill("Animal Handling", "WIS");
    private Skill arcana = new Skill("Arcana", "INT");
    private Skill athletics = new Skill("Athletics", "STR");
    private Skill deception = new Skill("Deception", "CHA");
    private Skill history = new Skill("History", "INT");
    private Skill insight = new Skill("Insight", "WIS");
    private Skill intimidation = new Skill("Intimidation", "CHA");
    private Skill invesigation = new Skill("Investigation", "INT");
    private Skill medicine = new Skill("Medicine", "WIS");
    private Skill nature = new Skill("Nature", "INT");
    private Skill perception = new Skill("Perception", "WIS");
    private Skill performance = new Skill("Performance", "CHA");
    private Skill persuasion = new Skill("Persuasion", "CHA");
    private Skill religion = new Skill("Religion", "INT");
    private Skill sleightOfHand = new Skill("Sleight of Hand", "DEX");
    private Skill stealth = new Skill("Stealth", "DEX");
    private Skill survival = new Skill("Survival", "WIS");


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
        return strength.getAbilityScore();
    }

    public int getStrengthModifier() {
        return strength.getAbilityModifier();
    }

    // DEXTERITY
    public void setDexScore() {
        dexterity.setAbilityScore(keyboard.nextInt());
    }

    public int getDexScore() {
        return dexterity.getAbilityScore();
    }

    public int getDexModifier() {
        return dexterity.getAbilityModifier();
    }

    // CONSTITUTION
    public void setConScore() {
        constitution.setAbilityScore(keyboard.nextInt());
    }

    public int getConScore() {
        return constitution.getAbilityScore();
    }

    public int getConModifier() {
        return constitution.getAbilityModifier();
    }

    // INTELLIGENCE
    public void setIntScore() {
        intelligence.setAbilityScore(keyboard.nextInt());
    }

    public int getIntScore() {
        return intelligence.getAbilityScore();
    }

    public int getIntModifier() {
        return intelligence.getAbilityModifier();
    }

    // WISDOM

    public void setWisScore() {
        wisdom.setAbilityScore(keyboard.nextInt());
    }

    public int getWisScore() {
        return wisdom.getAbilityScore();
    }

    public int getWisModifier() {
        return wisdom.getAbilityModifier();
    }

    // CHARISMA

    public void setChaScore() {
        charisma.setAbilityScore(keyboard.nextInt());
    }

    public int getChaScore() {
        return charisma.getAbilityScore();
    }

    public int getChaModifier() {
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

    //SKILLS
    public void setSkills() {
        for(int i = 0; i < 25; ++i) {

        }
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
