import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class UserDB {
    LinkedList<User> users = new LinkedList<User>();
    public Scanner keyboard = new Scanner(System.in);
    public final String DELIM = "\t";
    public int user_count;

    public void read_file() {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("./src/users.json");
            JSONArray userList = (JSONArray)jsonParser.parse(reader);

            for(Object o : userList) {
                JSONObject user = (JSONObject) o;

                String username = (String) user.get("username");
                String account_type = (String) user.get("account-type");
                String password = (String) user.get("password");
                users.add(new User(username, account_type,password));
                user_count++;
            }

        }
        catch(Exception e) {
            System.out.println(e);
        }

    }
    public void change_password(String username, int account_index) {
        String password = users.get(account_index).get_password();
        String attempt = "none";
        while(!attempt.equals(password)) {
            System.out.println("Please enter your current password: ");
            attempt = keyboard.next();
            if(attempt.equals(password))
                break;
        }
        System.out.println("Enter new password: ");
        password = keyboard.next();
        users.get(account_index).set_password(password);
        System.out.println("Your password has been changed!\n");
    }
/*    public void read_file(String a_file_name) {
        try {
            for(int i = 0; i < user_count; i++) {
                users.remove(i);
            }
            Scanner fileReader = new Scanner(new File(a_file_name));
            while(fileReader.hasNextLine()) {
                String fileLine = fileReader.nextLine();
                String[] splitLine = fileLine.split(DELIM);
                if(splitLine.length > 3)
                    continue;
                users.add(new User(splitLine[0], splitLine[1], splitLine[2]));
                user_count++;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }*/
    public void reset_users() {
        System.out.println(user_count);
        for(User user : users)
        {
            users.remove(user);
        }
    }
    public User create_account(LinkedList<User> user_list) {
        System.out.println("Enter a user name.");
        String user_name = keyboard.next();
        keyboard.nextLine();
        boolean scanning = true;
        boolean foundDupe = false;
        while(scanning) {
            foundDupe = false;
            for (User u : user_list) {
                if (u.get_user_name().equals(user_name)) {
                    System.out.println("User already exists. Enter a new user name.");
                    user_name = keyboard.nextLine();
                    foundDupe = true;
                    scanning = false;
                }
            }
            if (foundDupe == true) {
                scanning = true;
            }
            else
                scanning = false;
        }
    String account_type = "none";
    int account_num= 0;
    String password;
    System.out.println("Select an account type: "
            +"\n1) Dungeon Master"
            + "\n2) Player"
            + "\n3) Admin");
    account_num = keyboard.nextInt();
    switch (account_num) {
        case 1: account_type = "Dungeon_Master";
                break;
        case 2: account_type = "Player";
                break;
        case 3: account_type = "Admin";
                break;
        default: System.out.println("Incorrect Selection");
    }
    System.out.println("Enter a password: ");
    password = keyboard.next();
    System.out.println("UserName: "+user_name);
    user_count++;
    return new User(user_name, account_type, password);
    }
}
