public class Skill {
    private int modifier;

    public Skill() {
        this.setModifier(0);
    }

    public Skill(int newModifier) {
        this.setModifier(newModifier);
    }

    public void setModifier(int newModifier) {
        this.modifier = newModifier;
    }

    public int getModifier() {
        return this.modifier;
    }
}
