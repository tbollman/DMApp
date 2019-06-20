public class User 
{
    private String userName;
    private String accountType;
    private String password;
    public User() 
    {
        userName = accountType = password = "none";
    }
    public User(String a_user_name, String an_account_type, String a_password) 
    {
        setUserName(a_user_name);
        setAccountType(an_account_type);
        setPassword(a_password);
    }
    public String getUserName() 
    {
        return userName;
    }
    public String getAccountType() 
    {
        return accountType;
    }
    public String getPassword() 
    {
        return password;
    }
    public void setUserName(String aUserName) 
    {
        userName = aUserName;
    }
    public void setAccountType(String anAccountType) 
    {
        accountType = anAccountType;
    }
    public void setPassword(String aPassword) 
    {
        password = aPassword;
    }
}
