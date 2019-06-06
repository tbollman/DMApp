import java.util.Scanner;

public class CharacterSheet {
    Scanner keyboard = new Scanner(System.in);

    private String username;
    private String characterName;
    private String characterRace;
    private String characterClass;
    private String characterBackground;
    private int armorClass;
    private int initiative;
    private int speed;

    /*
     *  an array to store the ability scores and modifiers
     *  abilities[0] = strength
     *  abilities[1] = dexterity
     *  abilities[2] = constitution
     *  abilities[3] = intelligence
     *  abilities[4] = wisdom
     *  abilities[5] = charisma
     */
    Ability[] abilities = new Ability[6];

    /*
     * this constructor will get input from the player
     * to fill out a character sheet
     * potentially will save to json file
     */
    public CharacterSheet() {

    }

    //set ability scores and get ability modifiers
    public void setAbilitiy(int location, int newNum) {
        abilities[location].setAbilityScore(newNum);
    }

    public int getAbility(int location) {
        return abilities[location].getAbilityModifier();
    }

    //getters and setters
    public void setCharacterName() {
        System.out.println("Enter your Character Name: ");
        this.characterName = keyboard.nextLine();
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

    public void setCharacterName(String newClass) {
        this.characterClass = newClass;
    }

    public String getCharacterClass() {
        return this.characterClass;
    }
}
