import java.util.Scanner;
public class CharacterDriver {
    public static void main(String[] args) {
        System.out.println("Character Driver");
        Scanner keyboard = new Scanner(System.in);

        CharacterSheet quintus = new CharacterSheet();

        quintus.characterCreator();

        quintus.displayCharacterInfo();

    }  // end of main method
}
