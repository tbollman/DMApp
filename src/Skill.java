public class Skill {
    private String name;
    private boolean isProficient;
    private int modifier;
    private String abilityMod;

    public Skill() {
        this.setName("skill");
        this.setProficiency(false);
        this.setModifier(0);
        this.setAbilityMod("Intelligence");
    }

    public Skill(String newName, String newAbilityMod) {
        this.setName(newName);
        this.setProficiency(false);
        this.setModifier(0);
        this.setAbilityMod(newAbilityMod);
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void setProficiency(boolean newBool) {
        if(newBool = true){
            this.isProficient = true;
        } else {
            this.isProficient = false;
        }
    }

    public boolean getProficiency() {
        return this.isProficient;
    }

    public void setModifier(int newMod) {
        this.modifier = newMod;
    }

    public int getModifier() {
        return this.modifier;
    }

    public void setAbilityMod(String newAbilityMod) {
        this.abilityMod = newAbilityMod;
    }

    public String getAbilityMod() {
        return this.abilityMod;
    }
}
