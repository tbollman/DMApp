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
    private int proficiencyBonus;

    private Ability strength = new Ability();
    private Ability dexterity = new Ability();
    private Ability constitution = new Ability();
    private Ability intelligence = new Ability();
    private Ability wisdom = new Ability();
    private Ability charisma = new Ability();

    private Skill[] skills = new Skill[24];
    {
        for (int i = 0; i < 24; i++) {
            skills[i] = new Skill();
        }
    }

    /*
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
 */

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
        proficiencyBonus = 2;

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

    public String getSkillName(int location) {
        String skillName;
        switch (location) {
            case 0:
                skillName = "Strength Save";
                break;
            case 1:
                skillName = "Dexterity Save";
                break;
            case 2:
                skillName = "Constitution Save";
                break;
            case 3:
                skillName = "Intelligence Save";
                break;
            case 4:
                skillName = "Wisdom Save";
                break;
            case 5:
                skillName = "Charisma Save";
                break;
            case 6:
                skillName = "Acrobatics";
                break;
            case 7:
                skillName = "Animal Handling";
                break;
            case 8:
                skillName = "Arcana";
                break;
            case 9:
                skillName = "Athletics";
                break;
            case 10:
                skillName = "Deception";
                break;
            case 11:
                skillName = "History";
                break;
            case 12:
                skillName = "Insight";
                break;
            case 13:
                skillName = "Intimidation";
                break;
            case 14:
                skillName = "Investigation";
                break;
            case 15:
                skillName = "Medicine";
                break;
            case 16:
                skillName = "Nature";
                break;
            case 17:
                skillName = "Perception";
                break;
            case 18:
                skillName = "Performance";
                break;
            case 19:
                skillName = "Persuasion";
                break;
            case 20:
                skillName = "Religion";
                break;
            case 21:
                skillName = "Sleight of Hand";
                break;
            case 22:
                skillName = "Stealth";
                break;
            case 23:
                skillName = "Survival";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + location);
        }
        return skillName;
    }

    public String getSkillAttribute(int location) {
        String skillAtt;
        switch (location) {
            case 0:
                skillAtt = "STR";
                break;
            case 1:
                skillAtt = "DEX";
                break;
            case 2:
                skillAtt = "CON";
                break;
            case 3:
                skillAtt = "INT";
                break;
            case 4:
                skillAtt = "WIS";
                break;
            case 5:
                skillAtt = "CHA";
                break;
            case 6:
                skillAtt = "DEX";
                break;
            case 7:
                skillAtt = "WIS";
                break;
            case 8:
                skillAtt = "INT";
                break;
            case 9:
                skillAtt = "STR";
                break;
            case 10:
                skillAtt = "CHA";
                break;
            case 11:
                skillAtt = "INT";
                break;
            case 12:
                skillAtt = "WIS";
                break;
            case 13:
                skillAtt = "CHA";
                break;
            case 14:
                skillAtt = "INT";
                break;
            case 15:
                skillAtt = "WIS";
                break;
            case 16:
                skillAtt = "INT";
                break;
            case 17:
                skillAtt = "WIS";
                break;
            case 18:
                skillAtt = "CHA";
                break;
            case 19:
                skillAtt = "CHA";
                break;
            case 20:
                skillAtt = "INT";
                break;
            case 21:
                skillAtt = "DEX";
                break;
            case 22:
                skillAtt = "DEX";
                break;
            case 23:
                skillAtt = "WIS";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + location);
        }
        return skillAtt;
    }
    //SKILLS
    //each skill has a name and associated attribute
    //each skill needs to have its proficiency and modifier set
    public void setSkill(int location, int skillMod) {
            skills[location].setName(getSkillName(location));
            skills[location].setAbilityMod(getSkillAttribute(location));
    }

    public void setProficient(int location) {
        skills[location].setProficiency(true);
    }

    public boolean getProficiency(int location) {
        return skills[location].getProficiency();
    }

    public int getSkill(int location) {
        int modifier;
        String attribute = skills[location].getAbilityMod();
        if (attribute == "STR") {
            modifier = this.getStrengthModifier();
        } else if (attribute == "DEX") {
            modifier = this.getDexModifier();
        } else if (attribute == "CON") {
            modifier = this.getConModifier();
        } else if (attribute == "INT") {
            modifier = this.getIntModifier();
        } else if (attribute == "WIS") {
            modifier = this.getWisModifier();
        } else if (attribute == "CHA") {
            modifier = this.getChaModifier();
        } else {
            modifier = 0;
        }

        boolean isProficient = skills[location].getProficiency();

        if (isProficient) {
            modifier += this.getProficiencyBonus();
        }

        return modifier;
    }
    
    //getters and setters
    public void setCharacterName(String newName) {
        this.characterName = newName;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public void setCharacterRace(String newRace) {
        this.characterRace = newRace;
    }

    public String getCharacterRace() {
        return this.characterRace;
    }

    public void setCharacterClass(String newClass) {
        this.characterClass = newClass;
    }

    public String getCharacterClass() {
        return this.characterClass;
    }

    public void setCharacterBackground(String newBackground) {
        this.characterBackground = newBackground;
    }

    public void setArmorClass(int newAC) {
        this.armorClass = newAC;
    }

    public int getArmorClass() {
        return this.armorClass;
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setProficiencyBonus(int newPB) {
        this.proficiencyBonus = newPB;
    }

    public int getProficiencyBonus() {
        return this.proficiencyBonus;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getInitiative() {
        return this.initiative;
    }

    // Character Creator Method will use all of the set methods to prompt the user to enter in their information
    public void characterCreator() {
        System.out.println("Enter character name: ");
        this.setCharacterName(keyboard.nextLine());
        System.out.println("Enter character race: ");
        this.setCharacterRace(keyboard.nextLine());
        System.out.println("Enter character class: ");
        this.setCharacterClass(keyboard.nextLine());
        System.out.println("Enter character background: ");
        this.setCharacterBackground(keyboard.nextLine());
        System.out.println("Enter armor class: ");
        System.out.println("Initiative: ");
        System.out.println("Enter speed: ");
        System.out.println("Enter proficiency bonus: ");

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
