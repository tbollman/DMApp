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
    }

    @org.junit.jupiter.api.Test
    void readCharacters() {
        users.userName = "tbollman";
        users.readCharacters();
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
        assertEquals(ExpectedOne, actual.get(0), "The first String is: Tom");
        assertEquals(ExpectedTwo, actual.get(1), "The second String is: Dick");
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
