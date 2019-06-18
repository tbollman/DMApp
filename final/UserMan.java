import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class UserMan {
  /*********************************************************************************************************************
   * Stores the Users read in from "users.json" for use by various methods
   */
  LinkedList<User> users = new LinkedList<User>();
  /*********************************************************************************************************************
   * DELIM used for reading in List of items stored as a single string in "character_sheet.json"
   */
  public static final String DELIM = ",";
  /*********************************************************************************************************************
   * Keeps track of number of users in "users.json"
   */
  public int user_count;
  /*********************************************************************************************************************
   * Keeps track of account index in LinkedList of Users of the user currently logged in.
   */
  public int account_index;
  /*********************************************************************************************************************
   * Keeps track of username of user currently logged in.
   */
  public String user_name;
  public boolean logged_in = false;
  /*********************************************************************************************************************
   * Stores all CharacterSheet(s) read in from "character_sheet.json" to be rewrote later.
   */
  LinkedList<CharacterSheet> characters = new LinkedList<CharacterSheet>();
  /*********************************************************************************************************************
   * Stores CharacterSheet(s) whose username values match the username of the User currently logged in.
   */
  LinkedList<CharacterSheet> owned_characters = new LinkedList<CharacterSheet>();
  /*********************************************************************************************************************
   * Keeps track of the number of characters read in from "character_sheet.json"
   */
  public int character_count = 0;
  /*********************************************************************************************************************
   * Keeps track of the CharacterSheet(s) stored in LinkedList<CharacterSheet> owned_characters;
   */
  public int owned_character_count = 0;

  /*********************************************************************************************************************
   * Reads the JSON values stored in "users.json", parses them, creates a new instance of a User, and adds that instance
   * to the LinkedList of Users.
   */
  public void read_file() {
    JSONParser jsonParser = new JSONParser();
    try {
      JSONArray userList = (JSONArray)jsonParser.parse(new
          FileReader("./src/users.json"));
          for (Object o : userList) {
            JSONObject user = (JSONObject) o;
            String username = (String) user.get("username");
            String account_type = (String) user.get("account-type");
            String password = (String) user.get("password");
            users.add(new User(username, account_type, password));
            user_count++;
          }
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  /***********************************************************************************************************************
   * Reads the JSON values stored in "character_sheet.json", parses them, create a new instance of a CharacterSheet, and
   * adds that instance to the LinkedList of Characters. Then calls GetOwnedCharacters();
   *
   */
  public void read_characters() {
    JSONParser jsonParser = new JSONParser();
    try {
      JSONArray characterList = (JSONArray)jsonParser.parse(new FileReader("./src/character_sheet.json"));
      for (Object o : characterList) {
        JSONObject character = (JSONObject) o;
        String username = (String) character.get("Username");
          String characterName = (String) character.get("Character Name");
          int level = Integer.parseInt((String) character.get("Level"));
          String characterRace = (String) character.get("Character Race");
          String characterClass = (String) character.get("Character Class");
          String background = (String) character.get("Background");
          int strScore = Integer.parseInt((String) character.get("Strength Score"));
          int dexScore = Integer.parseInt((String) character.get("Dexterity Score"));
          int conScore = Integer.parseInt((String) character.get("Constitution Score"));
          int intScore = Integer.parseInt((String) character.get("Intelligence Score"));
          int wisScore = Integer.parseInt((String) character.get("Wisdom Score"));
          int chaScore = Integer.parseInt((String) character.get("Charisma Score"));

          int armorClass = Integer.parseInt((String) character.get("Armor Class"));
          int initiative = Integer.parseInt((String) character.get("Initiative"));
          int speed = Integer.parseInt((String) character.get("Speed"));
          String hitDie = (String) character.get("Hit Die");
          int hitPoints = Integer.parseInt((String) character.get("Hit Points"));
          int proficiency = Integer.parseInt((String) character.get("Proficiency Bonus"));
          LinkedList<Integer> skills = new LinkedList<Integer>();
          int strengthSave = Integer.parseInt((String) character.get("Strength Save"));
          skills.add(strengthSave);
          int dexSave = Integer.parseInt((String) character.get("Dexterity Save"));
          skills.add(dexSave);
          int constitutionSave = Integer.parseInt((String) character.get("Constitution Save"));
          skills.add(constitutionSave);
          int intelligenceSave = Integer.parseInt((String) character.get("Intelligence Save"));
          skills.add(intelligenceSave);
          int wisdomSave = Integer.parseInt((String) character.get("Wisdom Save"));
          skills.add(wisdomSave);
          int charismaSave = Integer.parseInt((String) character.get("Charisma Save"));
          skills.add(charismaSave);
          int acrobatics = Integer.parseInt((String) character.get("Acrobatics"));
          skills.add(acrobatics);
          int animal_handling = Integer.parseInt((String) character.get("Animal Handling"));
          skills.add(animal_handling);
          int arcana = Integer.parseInt((String) character.get("Arcana"));
          skills.add(arcana);
          int athletics = Integer.parseInt((String) character.get("Athletics"));
          skills.add(athletics);
          int deception = Integer.parseInt((String) character.get("Deception"));
          skills.add(deception);
          int history = Integer.parseInt((String) character.get("History"));
          skills.add(history);
          int insight = Integer.parseInt((String) character.get("Insight"));
          skills.add(insight);
          int intimidation = Integer.parseInt((String) character.get("Intimidation"));
          skills.add(intimidation);
          int investigation = Integer.parseInt((String) character.get("Investigation"));
          skills.add(investigation);
          int medicine = Integer.parseInt((String) character.get("Medicine"));
          skills.add(medicine);
          int nature = Integer.parseInt((String) character.get("Nature"));
          skills.add(nature);
          int perception = Integer.parseInt((String) character.get("Perception"));
          skills.add(perception);
          int performance = Integer.parseInt((String) character.get("Performance"));
          skills.add(performance);
          int persuasion = Integer.parseInt((String) character.get("Persuasion"));
          skills.add(persuasion);
          int religion = Integer.parseInt((String) character.get("Religion"));
          skills.add(religion);
          int sleightOfHand = Integer.parseInt((String) character.get("Sleight of Hand"));
          skills.add(sleightOfHand);
          int stealth = Integer.parseInt((String) character.get("Stealth"));
          skills.add(stealth);
          int survival = Integer.parseInt((String) character.get("Survival"));
          skills.add(survival);
          LinkedList<String> languages = new LinkedList<String>();
          String languagesS = (String) character.get("Languages");
          StoreValues(languagesS, languages);
          LinkedList<String> features = new LinkedList<String>();
          LinkedList<String> weapons = new LinkedList<String>();
          LinkedList<String> armor = new LinkedList<String>();
          LinkedList<String> potions = new LinkedList<String>();
          LinkedList<String> supplies = new LinkedList<String>();
          LinkedList<String> spells = new LinkedList<String>();
          String featuresS = (String) character.get("Features");
          StoreValues(featuresS, features);
          String weaponsS = (String) character.get("Weapons");
          StoreValues(weaponsS, weapons);
          String armorS = (String) character.get("Armor");
          StoreValues(armorS, armor);
          String potionsS = (String) character.get("Potions");
          StoreValues(potionsS, potions);
          String suppliesS = (String) character.get("Supplies");
          StoreValues(suppliesS, supplies);
          String spellsS = (String) character.get("Spells");
          StoreValues(spellsS, spells);

          characters.add(new CharacterSheet(username,characterName,level, characterRace,characterClass,background,strScore,dexScore,conScore,intScore,wisScore,chaScore,armorClass,initiative,speed,hitDie,hitPoints,proficiency,skills,languages,features,weapons,armor,potions,supplies,spells));
          character_count++;
      }
      get_owned_characters();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  /*********************************************************************************************************************
   * Accepts parameter String, splits it at DELIM, and stores each value in the passed LinkedList before returning the LinkedList
   * @param line  -   Value read from JSON file
   * @param store -   line split and stored into LinkedList
   * @return
   */
  public LinkedList<String> StoreValues(String line, LinkedList<String> store) {
    String[] splitLine = line.split(DELIM);
    for (int i = 0; i < splitLine.length; i++)
      store.add(splitLine[i]);
    return store;
  }

  /*********************************************************************************************************************
   * Takes the LinkedList of characters, checks to see if the username attached to that CharacterSheet matches the
   * username of the User logged in, and adds that CharacterSheet to LinkedList owned_characters.
   */
  public void get_owned_characters() {
    for (int i = 0; i < character_count; i++) {
      if (characters.get(i).getUsername().equals(user_name)) {
        owned_characters.add(characters.get(i));
        owned_character_count++;
      }
    }
  }

  /*********************************************************************************************************************
   * Takes the LinkedList of Users, creates a JSONObject from each one, adds them to a JSONArray, and writes that
   * JSONArray to character_sheet.json.
   */
  public void write_file() {
    JSONArray userList = new JSONArray();
    for (int i = 0; i < user_count; i++) {
      JSONObject userDetails = new JSONObject();
      userDetails.put("username", users.get(i).get_user_name());
      userDetails.put("account-type", users.get(i).get_account_type());
      userDetails.put("password", users.get(i).get_password());

      userList.add(userDetails);
    }
    try (FileWriter file = new FileWriter("./src/users.json")) {
      file.write(userList.toJSONString());
      file.flush();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  /*********************************************************************************************************************
   * Finds a User from the LinkedList of users based upon their username.
   * @param username
   * @return
   */
  public boolean GetUser(String username) {
    boolean user_exists = false;
    for (int i = 0; i < user_count; i++) {
      if (username.equals(users.get(i).get_user_name())) {
        account_index = i;
        user_exists = true;
      }
    }
    return user_exists;
  }

  /*********************************************************************************************************************
   * Create a new account, verifies the username doesn't already exist, and writes the values of the new account to
   * "users.json".
   * @param username
   * @param account_type
   * @param password
   * @return
   */
  public boolean create_account(String username, int account_type, String password) {
    boolean is_valid = true;
    if (GetUser(username))
      is_valid = false;
    String type = "none";
    switch (account_type) {
      case 0: type = "Player";
              break;
      case 1: type = "Dungeon Master";
              break;
      case 2: type = "Admin";
              break;
      default: is_valid = false;
               break;
    }
    if(!is_valid)
      return is_valid;
    users.add(new User(username, type, password));
    user_count++;
    account_index = user_count;
    write_file();
    return is_valid;
  }

  /*********************************************************************************************************************
   * Takes in two Strings, username and password, checks if username exists, reads the associated password, and compares
   * it to the passed password. If they match, the username is stored as the logged in user, and true is returned.
   * @param username
   * @param password
   * @return
   */
  public boolean login_attempt(String username, String password) {
    if (GetUser(username)) {
      if (users.get(account_index).get_password().equals(password)) {
        logged_in = true;
        user_name = username;
      }
    }
    return logged_in;
  }

  /*********************************************************************************************************************
   * Takes in two Strings, new_password and old_password, compares the old_password to the password of the User currently
   * logged in, and if correct, replace the password of the user with new_password.
   * @param new_password
   * @param old_password
   * @return
   */
  public boolean change_password(String new_password, String old_password) {
    boolean passed = true;
    if (users.get(account_index).get_password().equals(old_password))
      users.get(account_index).set_password(new_password);
    else
      passed = false;
    write_file();
    return passed;
  }

}

