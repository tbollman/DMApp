/**
 * The Ability Class is used by the CharacterSheet class.
 * There are six abilities, Strength, Dexterity, Constitution,
 * Intelligence, Wisdom, and Charisma.
 * The Ability Score is the basic value of an ability, but the
 * Ability Modifier is more commonly used.
 * The Ability Modifier is determined by the formula (AbilityScore / 2) - 5
 */
public class Ability {
    /**
     *  Variables to hold Ability Score and Ability Modifier
     */
    private int abilityScore;
    private int abilityModifier;

    public static final int FIVE = 5;
    public static final int TWO = 2;

    /**
     * Default constructor.
     */
    public Ability() {
        this.setAbilityScore(10);
    }

    /**
     *  Sets the value of abilityScore to integer inputScore.
     * @param inputScore
     */
    public void setAbilityScore(int inputScore) {
        this.abilityScore = inputScore;
    }

    /**
     * Returns the value of abilityScore.
     * @return abilityScore
     */
    public int getAbilityScore() {
        return this.abilityScore;
    }

    /**
     * Calculates the Ability Modifier based on the Ability Score, stores it in abilityModifier, and returns it.
     * @return abilityModifier
     */
    public int getAbilityModifier() {
        this.abilityModifier = (this.abilityScore/TWO) - FIVE;
        return abilityModifier;
    }

}