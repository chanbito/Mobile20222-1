package br.edu.uniritter.mobile.mobile20222_1.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.model.User;

public class UserRepository {
    private List<User> users;
    private static UserRepository instance;

    private UserRepository() {
        super();
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

    public static UserRepository getInstance() {
        //if (instance == null) {
            instance = new UserRepository();
        //}
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }
    public User getUserById(int id) {
        User ret = null;
        for(User u : users) {
            if (u.getId() == id) {
                ret = u;
            }
        }
        return ret;
    }
    public User getUserByUserLogin(String login) {
        User ret = null;
        for(User u : users) {
            if (u.getUserLogin().equals(login)) {
                ret = u;
            }
        }
        return ret;
    }
}
