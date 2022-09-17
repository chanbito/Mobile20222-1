package br.edu.uniritter.mobile.mobile20222_1.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String userLogin;
    private String password;

    private static List<User> users;


    public User(int id, String name, String userLogin, String password) {
        this.id = id;
        this.name = name;
        this.userLogin = userLogin;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitulo() {
        return userLogin+" - "+name+" ("+id+")";
    }
    public String getPassword() {
        return password;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
            users.add( new User(1, "Jean", "jp1", "1234"));
            users.add( new User(2, "Jean 2", "jp2", "1234"));
            users.add( new User(3, "Jean 3", "jp3", "1234"));
            users.add( new User(4, "Jean 4", "jp4", "1234"));
            users.add( new User(11, "Jean 11", "jp1", "1234"));
            users.add( new User(12, "Jean 12", "jp2", "1234"));
            users.add( new User(13, "Jean 13", "jp3", "1234"));
            users.add( new User(14, "Jean 14", "jp4", "1234"));
        }
        return users;
    }
    public static User getUserById(int id) {
        User ret = null;
        getUsers();
        for(User u : users) {
            if (u.getId() == id) {
                ret = u;
            }
        }
        return ret;
    }
    public static User getUserByUserLogin(String login) {
        User ret = null;
        getUsers();
        for(User u : users) {
            if (u.getUserLogin().equals(login)) {
                ret = u;
            }
        }
        return ret;
    }
}
