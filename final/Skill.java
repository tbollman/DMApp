/**
 * The Skill class is used by the Character Sheet class.
 * There are 24 skills in total, each with a name, and each
 * containing an integer indicating what number is added to
 * a die roll when using the skill.
 */
public class Skill {
    private String name;
    private int modifier;

    /**
     * Default constructor sets the value of modifier to 0.
     */
    public Skill() {
        this.setName("");
        this.setModifier(0);
    }

    /**
     * Sets value of name to newName.
     * @param newName
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Returns value of name.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * A constructor that sets the value of modifier to integer newModifier.
     * @param newModifier
     */
    public Skill(int newModifier) {
        this.setModifier(newModifier);
    }

    /**
     * Sets the value of modifier to integer newModifier.
     * @param newModifier
     */
    public void setModifier(int newModifier) {
        this.modifier = newModifier;
    }

    /**
     * Returns the value of modifier.
     * @return modifier
     */
    public int getModifier() {
        return this.modifier;
    }
}