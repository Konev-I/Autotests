package org.test.utils;

public class User {
    private String fullName;
    private String login;
    private String password;

    public User(String uName, String uLogin, String uPassword){
        fullName = uName;
        login = uLogin;
        password = uPassword;
    }

    public User(String uLogin, String uPassword){
        login = uLogin;
        password = uPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
