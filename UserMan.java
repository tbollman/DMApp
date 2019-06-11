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
      if (users.get(account_index).get_password().equals(password))
        logged_in = true;
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

