import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class UserManTest {
    UserMan users = new UserMan();

    @org.junit.jupiter.api.Test
    void readFile() {
        users.readFile();
        int actual = users.userCount;
        assertEquals(7,actual, "7 Users Exist!");
        String actualName = users.get(0).getUserName();
        String actualPassword = users.get(0).getUserName();
        String actualType = users.get(0).getAccountType();
        assertEquals("tbollman", actualName, "First account is tbollman");
        assertEquals("player", actualType, "tbollman is a player");
        assertEquals("password7", actualPassword, "password is password7");
    }

    @org.junit.jupiter.api.Test
    void readCharacters() {
        users.userName = "tbollman";
        users.readCharacters();
        String actualCN = users.characters.get(0).getCharacterName();
        assertEquals("Quintus Metellus", actualCN, "Character 0 name is Quintus Metellus");
        int actualLvl = users.characters.get(0).getLevel();
        assertEquals(0,actualLvl, "Quintus' Level is 0");
        String actualCC = users.characters.get(0).getCharacterClass();
        assertEquals("Fighter", actualCC, "Character 0 class if fighter");
        String actualCR = users.characters.get(0).getCharacterRace();
        assertEquals("Human", actualCR, "Character 0 race is Human");
        String actualBg = users.characters.get(0).getBackground();
        assertEquals("City Watch", actualBg, "Character 0 background is City Watch");
        int actualAC = users.characters.get(0).getArmorClass();
        assertEquals(10, actualAC, "Character 0 Armor Class is 10");
        int actualInit = users.characters.get(0).getInitiative();
        assertEquals(0, actualInit, "Character 0 name is 0");
        int actualSpeed = users.characters.get(0).getSpeed();
        assertEquals(30, actualSpeed, "Character 0 speed is 30);
        int actualSS = users.characters.get(0).getStrengthScore();
        assertEquals(10, actualSS, "Character 0 score is 10);
        int actualDS = users.characters.get(0).getDexterityScore();
        assertEquals(10, actualDS, "Character 0 score is 10);
        int actualCoS = users.characters.get(0).getConstitutionScore();
        assertEquals(10, actualCoS, "Character 0 score is 10);
        int actualIS = users.characters.get(0).getIntelligenceScore();
        assertEquals(10, actualIS, "Character 0 score is 10);
        int actualWS = users.characters.get(0).getWisdomScore();
        assertEquals(10, actualWS, "Character 0 score is 10);
        int actualChS = users.characters.get(0).getCharismaScore();
        assertEquals(10, actualChS, "Character 0 score is 10);
        int actualProS = users.characters.get(0).getProficiencyBonus();
        assertEquals(10, actualProS, "Character 0 proficiency is 10);
        for(int i = 0; i < users.get(0).skill.size(); i++)
        {
            actual = users.get(0).getSkill(i);
            assertEquals(0, actual, "Skill "+i+"'s value is 0");
        }
        int actual = users.ownedCharacterCount;
        assertEquals(2, actual, "tbollman has 2 characters");
        String actualName = users.ownedCharacters.get(users.ownedCharacterCount-1).getCharacterName();
        assertEquals("Test Character", actualName, "Last owned characters name is Test Character");
    }

    @org.junit.jupiter.api.Test
    void storeValues() {
        LinkedList<String> actual = new LinkedList<String>();
        String test = "Tom,Dick,Harry";
        users.storeValues(test,actual);
        String ExpectedOne = "Tom";
        String ExpectedTwo = "Dick";
        String ExpectedThree = "Harry";
        assertEquals(ExpectedOne, actual.get(0), "The first String is: Tom");
        assertEquals(ExpectedTwo, actual.get(1), "The second String is: Dick");
        assertEquals(ExpectedThree, actual.get(2), "The second String is: Harry");
    }

    @org.junit.jupiter.api.Test
    void getOwnedCharacters() {
        users.userName = "tbollman";
        users.readCharacters();
        assertEquals(2,users.ownedCharacters.size(), "tbollman has 2 owned characters!");
        users = new UserMan();
        users.userName = "nshaw";
        users.readCharacters();
        assertEquals(1, users.ownedCharacters.size(), "nshaw has 1 character.");
    }

    @org.junit.jupiter.api.Test
    void getUser() {
        users.readFile();
        boolean actual = users.getUser("tbollman");
        assertEquals(true, actual, "tbollman account exists");
        actual = users.getUser("doesn'texist");
        assertEquals(false, actual, "doesn'texist account does not exist");
    }

    @org.junit.jupiter.api.Test
    void create_account() {
        users.readFile();
        boolean actual = users.create_account("tbollman", 0, "dummypassword");
        assertEquals(false, actual, "tbollman account already exists!");
        actual = users.create_account("testaccount", 1, "testpassword");
        assertEquals(true, actual, "testaccount account does not exist");
        String actualPassword = users.users.getLast().getPassword();
        assertEquals("testpassword", actualPassword, "Passwords do not match");
        users.users.removeLast();
    }

    @org.junit.jupiter.api.Test
    void login_attempt() {
        users.readFile();
        boolean actual = users.login_attempt("tbollman", "password7");
        assertEquals(true, actual, "Username and password are correct.");
        users.loggedIn = false;
        actual = users.login_attempt("tbollman", "badPassword");
        assertEquals(false, actual, "incorrect password.");
    }

    @org.junit.jupiter.api.Test
    void change_password() {
        users.readFile();
        users.getUser("nshaw");
        boolean actual = users.changePassword("testpassword", "newpassword");
        assertEquals(true, actual, "password should be changed.");
        actual = users.changePassword("testpassword", "newpassword");
        assertEquals(false,actual, "old password is incorrect");
        actual = users.changePassword("newpassword", "testpassword");
        assertEquals(true, actual, "password should be changed2.");
    }
}
