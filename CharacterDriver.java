public class CharacterDriver {
    public static void main(String[] args) {
        System.out.println("Character Driver");
        CharacterSheet quintus = new CharacterSheet();
        quintus.setCharacterName();
        System.out.println(quintus.getCharacterName());
    }  // end of main method
}
