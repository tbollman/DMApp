import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class UserMan {
  LinkedList<User> users = new LinkedList<User>();
  public static final String DELIM = ",";
  public Scanner keyboard = new Scanner(System.in);
  public int user_count;
  public int account_index;
  public String user_name;
  public boolean logged_in = false;
  LinkedList<CharacterSheet> characters = new LinkedList<CharacterSheet>();
  LinkedList<CharacterSheet> owned_characters = new LinkedList<CharacterSheet>();
  public int character_count = 0;
  public int owned_character_count = 0;

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
          String[] splitLangs = languagesS.split(DELIM);
          for(int i = 0; i < splitLangs.length; i++)
            languages.add(splitLangs[i]);
          LinkedList<String> features = new LinkedList<String>();
          LinkedList<String> weapons = new LinkedList<String>();
          LinkedList<String> armor = new LinkedList<String>();
          LinkedList<String> potions = new LinkedList<String>();
          LinkedList<String> supplies = new LinkedList<String>();
          LinkedList<String> spells = new LinkedList<String>();
          String featuresS = (String) character.get("Features");
          String[] splitFeats = featuresS.split(DELIM);
          for(int i = 0; i < splitFeats.length; i++)
            features.add(splitFeats[i]);
          String weaponsS = (String) character.get("Weapons");
          String[] splitWeaps = weaponsS.split(DELIM);
          for(int i = 0; i < splitWeaps.length; i++)
            weapons.add(splitWeaps[i]);
          String armorS = (String) character.get("Armor");
          String[] splitArms = armorS.split(DELIM);
          for(int i = 0; i < splitArms.length; i++)
            armor.add(splitArms[i]);
          String potionsS = (String) character.get("Potions");
          String[] splitPotions = potionsS.split(DELIM);
          for(int i = 0; i < splitPotions.length; i++)
            potions.add(splitPotions[i]);
          String suppliesS = (String) character.get("Supplies");
          String[] splitSupps = suppliesS.split(DELIM);
          for(int i = 0; i < splitSupps.length; i++)
          supplies.add(splitSupps[i]);
          String spellsS = (String) character.get("Spells");
          String[] splitSpells = spellsS.split(DELIM);
          for(int i = 0; i < splitSpells.length; i++)
          spells.add(splitSpells[i]);

          characters.add(new CharacterSheet(username,characterName,level, characterRace,characterClass,background,strScore,dexScore,conScore,intScore,wisScore,chaScore,armorClass,initiative,speed,hitDie,hitPoints,proficiency,skills,languages,features,weapons,armor,potions,supplies,spells));
          character_count++;
      }
      get_owned_characters();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
  public void get_owned_characters() {
    for (int i = 0; i < character_count; i++) {
      if (characters.get(i).getUsername().equals(user_name)) {
        owned_characters.add(characters.get(i));
        owned_character_count++;
      }
    }
  }

/*  public void write_character_sheet() {
    JSONArray characterList = new JSONArray();
    for(int i = 0; i < character_count; i++) {
      JSONObject characterDetails = new JSONObject();
      characterDetails.put("username", user_name);
    }
  }*/

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
  
  public boolean login_attempt(String username, String password) {
    if (GetUser(username)) {
      if (users.get(account_index).get_password().equals(password)) {
        logged_in = true;
        user_name = username;
      }
    }
    return logged_in;
  }


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

