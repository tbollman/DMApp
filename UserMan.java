import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class UserMan {
  LinkedList<User> users = new LinkedList<User>();
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
        String username = (String) character.get("username");
          String characterName = (String) character.get("Character Name");
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
          String language0 = (String) character.get("Language0");
          languages.add(language0);
          if((String) character.get("Language1") != null) {
            String language1 = (String) character.get("Language1");
            languages.add(language1);
          }

          LinkedList<String> features = (LinkedList<String>) character.get("features");
          LinkedList<String> weapons = (LinkedList<String>) character.get("Weapons");
          LinkedList<String> armor = (LinkedList<String>) character.get("Armor");
          LinkedList<String> potions = (LinkedList<String>) character.get("Potions");
          LinkedList<String> supplies = (LinkedList<String>) character.get("Supplies");
          LinkedList<String> spells = (LinkedList<String>) character.get("Spells");

          characters.add(new CharacterSheet(username,characterName,characterRace,characterClass,background,strScore,dexScore,conScore,intScore,wisScore,chaScore,armorClass,initiative,speed,hitDie,hitPoints,proficiency,skills,languages,features,weapons,armor,potions,supplies,spells));
          character_count++;
          System.out.println("Character Name: "+characterName+" Count: "+character_count);
      }
    }
    catch (Exception e) {
      System.out.println(e);
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
      case 3: type = "Admin";
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

