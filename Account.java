import java.util.Scanner;
import java.util.LinkedList;
import java.io.*;

public class Account {
public static UserDB user_list = new UserDB();
public static LinkedList<User> users = new LinkedList<User>();
public static Scanner keyboard = new Scanner(System.in);
public static boolean logged_in = false;
public static String user_name = "none";
public static int account_index = 0;
public static boolean exit_program = false;

    public static void main(String[] args) {
    GetUsers();
    System.out.println("Do you have an account?\nReply 'y' or 'n'\n");
    String response = keyboard.next();
    if(!response.equalsIgnoreCase("Y"))
        users.add(user_list.create_account(users));
    while(!exit_program) {
        MainMenu();
    }
    }
    public static void MainMenu() {
        int choice = 0;
        if(!logged_in) {
            login_attempt();
        }
        System.out.println("\n\n1)Create New Account" +
                "\n2)Print User Database" +
                "\n3)Update Password" +
                "\n9)Quit");
        choice = keyboard.nextInt();
        switch(choice) {
            case 1: users.add(user_list.create_account(users));
                    break;
            case 2: PrintUserList();
                    break;
            case 3: user_list.change_password(user_name, account_index);
                break;
            case 9: System.exit(0);
            default: System.out.println("Invalid Selection!");
        }
    }
    public static void GetUsers() {
        user_list.read_file();
        users = user_list.users;
        return;
    }
    public static void PrintUser(int account_index) {
        System.out.println("User Name: "+users.get(account_index).get_user_name()+"\tAccount Type: "+ users.get(account_index).get_account_type()+"\tPassword: "+users.get(account_index).get_password());

    }
    public static void PrintUserList() {
        System.out.println(user_list.user_count);
        for(int i = 0; i < user_list.user_count; i++) {
            System.out.println("User Name: "+users.get(i).get_user_name()+"\tAccount Type: "+ users.get(i).get_account_type()+"\tPassword: "+users.get(i).get_password());
        }
    }
    public static void login_attempt() {
        boolean main_quit = false;
        while(!main_quit) {
            System.out.println("Enter username: ");
            user_name = keyboard.next();
            for (int i = 0; i < user_list.user_count; i++) {
                if (users.get(i).get_user_name().equals(user_name)) {
                    account_index = i;
                    System.out.println("User Name: " + users.get(account_index).get_user_name());
                    boolean quit = false;
                    while (!quit) {
                        System.out.println("Enter password: ");
                        String password = keyboard.next();
                        if (password.equals(users.get(account_index).get_password())) {
                            System.out.println("Correct. \nLogging in now!");
                            logged_in = true;
                            return;
                        } else if (password.equalsIgnoreCase("quit")) {
                            quit = true;
                        } else {
                            System.out.println("Incorrect Password. Try Again.");
                            continue;
                        }
                    }
                } else {
                    continue;
                }
            }
            System.out.println("Account not found!");
        }
        return;
    }
}

