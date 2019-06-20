import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class UserMan 
{
  public final String sUserName = "username";
  public final String sAccountType = "account-type";
  public final String sPassword = "password";
  
  private final String sCharacterName = "Character Name";
  private final String sLevel = "Level";
  private final String sCharacterRace = "Character Race";
  private final String sCharacterClass = "Character Class";
  private final String sBackground = "Background";
  private final String sStrengthScore = "Strength Score";
  private final String sDexterityScore = "Dexterity Score";
  private final String sConstitutionScore = "Constitution Score";
  private final String sIntelligenceScore = "Intelligence Score";
  private final String sWisdomScore = "Wisdom Score";
  private final String sCharismaScore = "Charisma Score";
  private final String sArmorClass = "Armor Class";
  private final String sInitiavite = "Initiative";
  private final String sSpeed = "Speed";
  private final String sHitDie = "Hit Die";
  private final String sHitPoints = "Hit Points";
  private final String sProficiency = "Proficiency";
  private final String sStrengthSave = "Strength Save";
  private final String sDexteritySave = "Dexterity Save";
  private final String sConstitutionSave = "Constitution Save";
  private final String sIntelligenceSave = "Intelligence Save";
  private final String sWidsomSave = "Wisdom Save";
  private final String sCharismaSave = "Charisma Save";
  private final String sAcrobatics = "Acrobatics";
  private final String sAnimalHandling = "Animal Handling";
  private final String sArcana = "Arcana";
  private final String sAthletics = "Athletics";
  private final String sDeception = "Deception";
  private final String sHistory = "History";
  private final String sInsight = "Insight";
  private final String sIntimidation = "Intimidation";
  private final String sInvestigation = "Investigation";
  private final String sMedicine = "Medicine";
  private final String sNature = "Nature";
  private final String sPerception = "Perception";
  private final String sPerformance = "Performance";
  private final String sPersuasion = "Persuasion";
  private final String sReligion = "Religion";
  private final String sSleight = "Sleight of Hand";
  private final String sSurvival = "Survival";
  private final String sLanguages = "Languages";
  private final String sFeatures = "Features";
  private final String sWeapons = "Weapons";
  private final String sArmor = "Armor";
  private final String sPotions = "Potions";
  private final String sSupplies = "Supplies";
  private final String sSpells = "Spells";
  /**
   * Stores the Users read in from "users.json" for use by various methods
   */
  LinkedList<User> users = new LinkedList<User>();
  /**
   * DELIM used for reading in List of items stored as a single string in "character_sheet.json"
   */
  public static final String DELIM = ",";
  /**
   * Keeps track of number of users in "users.json"
   */
  public int userCount;
  /**
   * Keeps track of account index in LinkedList of Users of the user currently logged in.
   */
  public int accountIndex;
  /**
   * Keeps track of username of user currently logged in.
   */
  public String userName;
  public boolean loggedIn = false;
  /**
   * Stores all CharacterSheet(s) read in from "character_sheet.json" to be rewrote later.
   */
  LinkedList<CharacterSheet> characters = new LinkedList<CharacterSheet>();
  /**
   * Stores CharacterSheet(s) whose username values match the username of the User currently logged in.
   */
  LinkedList<CharacterSheet> ownedCharacters = new LinkedList<CharacterSheet>();
  /**
   * Keeps track of the number of characters read in from "character_sheet.json"
   */
  public int characterCount = 0;
  /**
   * Keeps track of the CharacterSheet(s) stored in LinkedList<CharacterSheet> ownedCharacters;
   */
  public int ownedCharacterCount = 0;
  /**
   * Reads the JSON values stored in "users.json", parses them, creates a new instance of a User, and adds that instance
   * to the LinkedList of Users.
   */
  public void readFile() 
  {
    JSONParser jsonParser = new JSONParser();
    try 
    {
      JSONArray userList = (JSONArray)jsonParser.parse(new
          FileReader("./src/users.json"));
          for (Object o : userList) 
          {
            JSONObject user = (JSONObject) o;
            String username = (String) user.get(sUserName);
            String accountType = (String) user.get(sAccountType);
            String password = (String) user.get(sPassword);
            users.add(new User(username, accountType, password));
            userCount++;
          }
    }
    catch (Exception e) 
    {
      System.out.println(e);
    }
  }

  /**
   * Reads the JSON values stored in "character_sheet.json", parses them, create a new instance of a CharacterSheet, and
   * adds that instance to the LinkedList of Characters. Then calls GetOwnedCharacters();
   *
   */
  public void readCharacters() 
  {
    JSONParser jsonParser = new JSONParser();
    try 
    {
      JSONArray characterList = (JSONArray)jsonParser.parse(new FileReader("./src/character_sheet.json"));
      for (Object o : characterList)
      {
        JSONObject character = (JSONObject) o;
          String username = (String) character.get(sUserName);
          String characterName = (String) character.get(sCharacterName);
          int level = Integer.parseInt((String) character.get(sLevel));
          String characterRace = (String) character.get(sCharacterRace);
          String characterClass = (String) character.get(sCharacter Class);
          String background = (String) character.get(sBackground);
          int strScore = Integer.parseInt((String) character.get(sStrengthScores));
          int dexScore = Integer.parseInt((String) character.get(sDexterityScore));
          int conScore = Integer.parseInt((String) character.get(sConstitutionScore));
          int intScore = Integer.parseInt((String) character.get(sIntelligenceScore));
          int wisScore = Integer.parseInt((String) character.get(sWisdomScore));
          int chaScore = Integer.parseInt((String) character.get(sCharismaScore));

          int armorClass = Integer.parseInt((String) character.get(sArmorClass));
          int initiative = Integer.parseInt((String) character.get(sInitiative));
          int speed = Integer.parseInt((String) character.get(sSpeed));
          String hitDie = (String) character.get(sHitDie);
          int hitPoints = Integer.parseInt((String) character.get(sHitPoints));
          int proficiency = Integer.parseInt((String) character.get(sProficiency));
          LinkedList<Integer> skills = new LinkedList<Integer>();
          int strengthSave = Integer.parseInt((String) character.get(sStrengthSave));
          skills.add(strengthSave);
          int dexSave = Integer.parseInt((String) character.get(sDexteritySave));
          skills.add(dexSave);
          int constitutionSave = Integer.parseInt((String) character.get(sConstitutionSave));
          skills.add(constitutionSave);
          int intelligenceSave = Integer.parseInt((String) character.get(sIntelligenceSave));
          skills.add(intelligenceSave);
          int wisdomSave = Integer.parseInt((String) character.get(sWisdomSave));
          skills.add(wisdomSave);
          int charismaSave = Integer.parseInt((String) character.get(sCharismaSave));
          skills.add(charismaSave);
          int acrobatics = Integer.parseInt((String) character.get(sAcrobatics));
          skills.add(acrobatics);
          int animal_handling = Integer.parseInt((String) character.get(sAnimalHandling));
          skills.add(animal_handling);
          int arcana = Integer.parseInt((String) character.get(sArcana));
          skills.add(arcana);
          int athletics = Integer.parseInt((String) character.get(sAthletics));
          skills.add(athletics);
          int deception = Integer.parseInt((String) character.get(sDeception));
          skills.add(deception);
          int history = Integer.parseInt((String) character.get(sHistory));
          skills.add(history);
          int insight = Integer.parseInt((String) character.get(sInsight));
          skills.add(insight);
          int intimidation = Integer.parseInt((String) character.get(sIntimidation));
          skills.add(intimidation);
          int investigation = Integer.parseInt((String) character.get(sInvestigation));
          skills.add(investigation);
          int medicine = Integer.parseInt((String) character.get(sMedicine));
          skills.add(medicine);
          int nature = Integer.parseInt((String) character.get(sNature));
          skills.add(nature);
          int perception = Integer.parseInt((String) character.get(sPerception));
          skills.add(perception);
          int performance = Integer.parseInt((String) character.get(sPerformance));
          skills.add(performance);
          int persuasion = Integer.parseInt((String) character.get(sPersuasion));
          skills.add(persuasion);
          int religion = Integer.parseInt((String) character.get(sReligion));
          skills.add(religion);
          int sleightOfHand = Integer.parseInt((String) character.get(sSleight));
          skills.add(sleightOfHand);
          int stealth = Integer.parseInt((String) character.get(sStealth));
          skills.add(stealth);
          int survival = Integer.parseInt((String) character.get(sSurvival));
          skills.add(survival);
          LinkedList<String> languages = new LinkedList<String>();
          String languagesS = (String) character.get(sLanguages);
          storeValues(languagesS, languages);
          LinkedList<String> features = new LinkedList<String>();
          LinkedList<String> weapons = new LinkedList<String>();
          LinkedList<String> armor = new LinkedList<String>();
          LinkedList<String> potions = new LinkedList<String>();
          LinkedList<String> supplies = new LinkedList<String>();
          LinkedList<String> spells = new LinkedList<String>();
          String featuresS = (String) character.get(sFeatures);
          storeValues(featuresS, features);
          String weaponsS = (String) character.get(sWeapons);
          storeValues(weaponsS, weapons);
          String armorS = (String) character.get(sArmor);
          storeValues(armorS, armor);
          String potionsS = (String) character.get(sPotions);
          storeValues(potionsS, potions);
          String suppliesS = (String) character.get(sSupplies);
          storeValues(suppliesS, supplies);
          String spellsS = (String) character.get(sSpells);
          storeValues(spellsS, spells);

          characters.add(new CharacterSheet(username,characterName,level, characterRace,characterClass,background,strScore,dexScore,conScore,intScore,wisScore,chaScore,armorClass,initiative,speed,hitDie,hitPoints,proficiency,skills,languages,features,weapons,armor,potions,supplies,spells));
          characterCount++;
      }
      getOwnedCharacters();
    } 
    catch (Exception e) 
    {
      System.out.println(e);
    }
  }

  /**
   * Accepts parameter String, splits it at DELIM, and stores each value in the passed LinkedList before returning the LinkedList
   * @param line  -   Value read from JSON file
   * @param store -   line split and stored into LinkedList
   * @return
   */
  public void storeValues(String line, LinkedList<String> store) 
  {
    String[] splitLine = line.split(DELIM);
    for (int i = 0; i < splitLine.length; i++)
      store.add(splitLine[i]);
  }

  /**
   * Takes the LinkedList of characters, checks to see if the username attached to that CharacterSheet matches the
   * username of the User logged in, and adds that CharacterSheet to LinkedList ownedCharacters.
   */
  public void getOwnedCharacters() 
  {
    for (int i = 0; i < characterCount; i++) 
    {
      if (characters.get(i).getUsername().equals(userName)) 
      {
        ownedCharacters.add(characters.get(i));
        ownedCharacterCount++;
      }
    }
  }

  /**
   * Takes the LinkedList of Users, creates a JSONObject from each one, adds them to a JSONArray, and writes that
   * JSONArray to character_sheet.json.
   */
  public void writeFile() 
  {
    JSONArray userList = new JSONArray();
    for (int i = 0; i < userCount; i++) 
    {
      JSONObject userDetails = new JSONObject();
      userDetails.put(sUserName, users.get(i).getUserName());
      userDetails.put(sAccountType, users.get(i).getAccountType());
      userDetails.put(sPassword, users.get(i).getPassword());

      userList.add(userDetails);
    }
    try (FileWriter file = new FileWriter("./src/users.json")) 
    {
      file.write(userList.toJSONString());
      file.flush();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Finds a User from the LinkedList of users based upon their username.
   * @param username
   * @return
   */
  public boolean getUser(String username) 
  {
    boolean user_exists = false;
    for (int i = 0; i < userCount; i++) 
    {
      if (username.equals(users.get(i).getUserName())) 
      {
        accountIndex = i;
        user_exists = true;
      }
    }
    return user_exists;
  }

  /**
   * Create a new account, verifies the username doesn't already exist, and writes the values of the new account to
   * "users.json".
   * @param username
   * @param account_type
   * @param password
   * @return
   */
  public boolean create_account(String username, int account_type, String password) 
  {
    boolean is_valid = true;
    if (getUser(username))
      is_valid = false;
    String type = "none";
    switch (account_type) 
    {
      case 0: 
        type = "Player";
        break;
      case 1: 
        type = "Dungeon Master";
        break;
      case 2: 
        type = "Admin";
        break;
      default:
        break;
    }
    if(!is_valid)
      return is_valid;
    users.add(new User(username, type, password));
    userCount++;
    accountIndex = userCount;
    writeFile();
    return is_valid;
  }

  /**
   * Takes in two Strings, username and password, checks if username exists, reads the associated password, and compares
   * it to the passed password. If they match, the username is stored as the logged in user, and true is returned.
   * @param username
   * @param password
   * @return
   */
  public boolean loginAttempt(String username, String password) 
  {
    if (getUser(username)) 
    {
      if (users.get(accountIndex).getPassword().equals(password)) 
      {
        loggedIn = true;
        userName = username;
      }
    }
    return loggedIn;
  }

  /*********************************************************************************************************************
   * Takes in two Strings, new_password and old_password, compares the old_password to the password of the User currently
   * logged in, and if correct, replace the password of the user with new_password.
   * @param new_password
   * @param old_password
   * @return
   */
  public boolean changePassword(String newPassword, String oldPassword) 
  {
    boolean passed = true;
    if (users.get(accountIndex).getPassword().equals(old_password))
      users.get(accountIndex).setPassword(new_password);
    else
      passed = false;
    writeFile();
    return passed;
  }

}

