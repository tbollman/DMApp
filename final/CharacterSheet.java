import java.util.LinkedList;

/**
 * The CharacterSheet class manages all the information needed for a player to keep track of their character.
 */
public class CharacterSheet {
    /**
     * These variables hold biographical information for the character.
     */
    private String username;
    private String characterName;
    private String characterRace;
    private String characterClass;
    private String characterBackground;
    private int armorClass;
    private int initiative;
    private int speed;

    private String hitDie;
    private int hitPoints;

    private Ability strength = new Ability();
    private Ability dexterity = new Ability();
    private Ability constitution = new Ability();
    private Ability intelligence = new Ability();
    private Ability wisdom = new Ability();
    private Ability charisma = new Ability();

    private int proficiencyBonus;

    private static final int skillNum = 24;

    private String[] skillNames = {"Strength Save", "Dexterity Save", "Constitution Save",
                                    "Intelligence Save", "Wisdom Save", "Charisma Save",
                                    "Acrobatics", "Animal Handling", "Arcana",
                                    "Athletics", "Deception", "History",
                                    "Insight", "Intimidation", "Investigation",
                                    "Medicine", "Nature", "Perception",
                                    "Performance", "Persuasion", "Religion",
                                    "Sleight of Hand", "Stealth", "Survival"}

    private Skill[] skills = new Skill[skillNum];
    {
        for (int i = 0; i < skillNum; i++) {
            skills[i] = new Skill();
        }
    }

    /**
     * Default constructor.
     */
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

    /**
     * Constructor that takes in as paramaters all information regarding a character.
     * @param newUserName
     * @param newCharacterName
     * @param newCharacterRace
     * @param newCharacterClass
     * @param newCharacterBackground
     * @param strScore
     * @param dexScore
     * @param conScore
     * @param intScore
     * @param wisScore
     * @param chaScore
     * @param newAC
     * @param newInit
     * @param newSpeed
     * @param newhitDie
     * @param HP
     * @param newPB
     * @param nSkills
     * @param languages
     * @param features
     * @param weapons
     * @param armor
     * @param potions
     * @param supplies
     * @param spells
     */
    public CharacterSheet(String newUserName, String newCharacterName, String newCharacterRace, String newCharacterClass,
                          String newCharacterBackground, int strScore, int dexScore, int conScore, int intScore, int wisScore,
                          int chaScore, int newAC, int newInit, int newSpeed, String newhitDie, int HP, int newPB, LinkedList<Integer> nSkills,
                          LinkedList<String> languages, LinkedList<String> features, LinkedList<String> weapons, LinkedList<String> armor,
                          LinkedList<String> potions, LinkedList<String> supplies, LinkedList<String> spells) {
        username = newUserName;
        characterName = newCharacterName;
        characterRace = newCharacterRace;
        characterClass = newCharacterClass;
        characterBackground = newCharacterBackground;
        armorClass = newAC;
        initiative = newInit;
        speed = newSpeed;

        hitDie = newhitDie;
        hitPoints = HP;

        strength.setAbilityScore(strScore);
        dexterity.setAbilityScore(dexScore);
        constitution.setAbilityScore(conScore);
        intelligence.setAbilityScore(intScore);
        wisdom.setAbilityScore(wisScore);
        charisma.setAbilityScore(chaScore);

        proficiencyBonus = newPB;
        for (int i = 0; i < skills.length; i++) {
            skills[i] = new Skill();
            skills[i].setModifier(nSkills.pop());
        }
    }

    /**
     * Sets the Strength Score to integer newScore.
     * @param newScore
     */
    public void setStrengthScore(int newScore) {
        strength.setAbilityScore(newScore);
    }

    /**
     *
     * @return strength.getAbilityScore()
     */
    public int getStrengthScore() {
        return strength.getAbilityScore();
    }

    /**
     * Calls getAbilityModifier from the Ability Class and returns the result.
     * @return strength.getAbilityModifier()
     */
    public int getStrengthModifier() {
        return strength.getAbilityModifier();
    }

    /**
     * Sets the Dexterity Score to integer newScore.
     * @param newScore
     */
    public void setDexScore(int newScore) {
        dexterity.setAbilityScore(newScore);
    }

    /**
     * Returns the value stored in the ability.
     * @return dexterity.getAbilityScore()
     */
    public int getDexScore() {
        return dexterity.getAbilityScore();
    }

    /**
     * Calls getAbilityModifier from the Ability Class and returns the result.
     * @return dexterity.getAbilityModifier()
     */
    public int getDexModifier() {
        return dexterity.getAbilityModifier();
    }

    /**
     * Sets the Constitution Score to integer newScore.
     * @param newScore
     */
    public void setConScore(int newScore) {
        constitution.setAbilityScore(newScore);
    }

    /**
     * Returns the value stored in the ability.
     * @return constitution.getAbilityScore()
     */
    public int getConScore() {
        return constitution.getAbilityScore();
    }

    /**
     * Calls getAbilityModifier from the Ability Class and returns the result.
     * @return constitution.getAbilityModifier()
     */
    public int getConModifier() {
        return constitution.getAbilityModifier();
    }

    /**
     * Sets the Intelligence Score to integer newScore.
     * @param newScore
     */
    public void setIntScore(int newScore) {
        intelligence.setAbilityScore(newScore);
    }

    /**
     * Returns the value stored in the ability.
     * @return intelligence.getAbilityScore()
     */
    public int getIntScore() {
        return intelligence.getAbilityScore();
    }

    /**
     * Calls getAbilityModifier from the Ability Class and returns the result.
     * @return intelligence.getAbilityModifier()
     */
    public int getIntModifier() {
        return intelligence.getAbilityModifier();
    }

    /**
     * Sets the Wisdom Score to integer newScore.
     * @param newScore
     */
    public void setWisScore(int newScore) {
        wisdom.setAbilityScore(newScore);
    }

    /**
     * Returns the value stored in the ability.
     * @return wisdom.getAbilityScore()
     */
    public int getWisScore() {
        return wisdom.getAbilityScore();
    }

    /**
     * Calls getAbilityModifier from the Ability Class and returns the result.
     * @return wisdom.getAbilityModifier()
     */
    public int getWisModifier() {
        return wisdom.getAbilityModifier();
    }

    /**
     * Sets the Charisma Score to integer newScore.
     * @param newScore
     */
    public void setChaScore(int newScore) {
        charisma.setAbilityScore(newScore);
    }

    /**
     * Returns the value stored in the ability.
     * @return charisma.getAbilityScore()
     */
    public int getChaScore() {
        return charisma.getAbilityScore();
    }

    /**
     * Calls getAbilityModifier from the Ability Class and returns the result.
     * @return charisma.getAbilityModifier()
     */
    public int getChaModifier() {
        return charisma.getAbilityModifier();
    }

    /**
     * Takes in an integer and searches the array skillNames for the String at that location.
     * @param location
     * @return skillNames[location]
     */
    public String getSkillName(int location) {
        return skillNames[location];
    }

    /**
     * Takes in two integers. The first is the index of the array of skills. The second is the modifier that will be
     * contained at that index.
     * @param location
     * @param newInt
     */
    public void setSkill(int location, int newInt) {
        skills[location].setModifier(newInt);
    }

    /**
     * Takes in an integer and searches the array skills for the integer at that location.
     * @param location
     * @return skills[location].getModifier()
     */
    public int getSkill(int location) {
        return skills[location].getModifier();
    }

    /**
     * Sets the username.
     * @param newName
     */
    public void setUsername(String newName) {
        this.username = newName;
    }

    /**
     * Returns the username.
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the character name.
     * @param newName
     */
    public void setCharacterName(String newName) {
        this.characterName = newName;
    }

    /**
     * Returns the character name.
     * @return characterName
     */
    public String getCharacterName() {
        return this.characterName;
    }

    /**
     * Sets the character race.
     * @param newRace
     */
    public void setCharacterRace(String newRace) {
        this.characterRace = newRace;
    }

    /**
     * Returns the character race.
     * @return characterRace
     */
    public String getCharacterRace() {
        return this.characterRace;
    }

    /**
     * Sets the character class.
     * @param newClass
     */
    public void setCharacterClass(String newClass) {
        this.characterClass = newClass;
    }

    /**
     * Returns the character class.
     * @return characterClass
     */
    public String getCharacterClass() {
        return this.characterClass;
    }

    /**
     * sets the character background.
     * @param newBackground
     */
    public void setCharacterBackground(String newBackground) {
        this.characterBackground = newBackground;
    }

    /**
     * Returns the character background.
     * @return
     */
    public String getCharacterBackground() {
        return this.characterBackground;
    }

    /**
     * Sets the armor class.
     * @param newAC
     */
    public void setArmorClass(int newAC) {
        this.armorClass = newAC;
    }

    /**
     * Returns the armor class.
     * @return armorClass
     */
    public int getArmorClass() {
        return this.armorClass;
    }

    /**
     * Sets the speed.
     * @param newSpeed
     */
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    /**
     * Returns the speed.
     * @return speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Sets the proficiency bonus
     * @param newPB
     */
    public void setProficiencyBonus(int newPB) {
        this.proficiencyBonus = newPB;
    }

    /**
     * Returns the proficiency bonus.
     * @return proficiency
     */
    public int getProficiencyBonus() {
        return this.proficiencyBonus;
    }

    /**
     * Sets the initiative.
     * @param initiative
     */
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    /**
     * Returns the initiative.
     * @return initiative
     */
    public int getInitiative() {
        return this.initiative;
    }
}
