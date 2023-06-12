package ru.purusov.spring.project2Boot.service;



import ru.purusov.spring.project2Boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers ();
    Object getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser( User user);
}