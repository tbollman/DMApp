public class User {
    private String user_name;
    private String account_type;
    private String password;
    public User() {
        user_name = account_type = password = "none";
    }
    public User(String a_user_name, String an_account_type, String a_password) {
        set_user_name(a_user_name);
        set_account_type(an_account_type);
        set_password(a_password);
    }
    public String get_user_name() {
        return user_name;
    }
    public String get_account_type() {
        return account_type;
    }
    public String get_password() {
        return password;
    }
    public void set_user_name(String a_user_name) {
        user_name = a_user_name;
    }
    public void set_account_type(String an_account_type) {
        account_type = an_account_type;
    }
    public void set_password(String a_password) {
        password = a_password;
    }
}