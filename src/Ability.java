public class Ability {

    private int abilityScore;
    private int abilityModifier;

    //default constructor
    public Ability() {
        this.setAbilityScore(10);
    }

    //setters and getters
    public void setAbilityScore(int inputScore) {
        this.abilityScore = inputScore;
    }

    public int getAbilityScore() {
        return this.abilityScore;
    }

    public int getAbilityModifier() {
        this.abilityModifier = (this.abilityScore/2) - 5;
        return abilityModifier;
    }

}
