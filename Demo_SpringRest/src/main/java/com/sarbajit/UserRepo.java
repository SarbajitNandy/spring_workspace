package com.sarbajit;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    private List<User> list_user;

    public UserRepo() {
        list_user = new ArrayList<>();
        list_user.add(new User("Sarbajit","1234"));
    }

    public User addNewUser(String usrName, String passWord) throws UsernameNotFoundException {

        if (list_user.stream().anyMatch(u -> u.getUserName().equals(usrName)))
            throw new UsernameNotFoundException(usrName + " already exists");

        User u = new User(usrName,passWord);
        list_user.add(u);
        return u;
    }

    public User findUserByUsername(String userName) throws UsernameNotFoundException {
        for(User u : list_user) {
            if (u.getUserName().equals(userName)) return u;
        }
        throw new UsernameNotFoundException(userName + " not found.");
    }


}
