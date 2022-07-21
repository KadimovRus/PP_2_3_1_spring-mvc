package jm.task.mvc.dao;

import jm.task.mvc.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    User getUserById(Long id);

    void editUser(User user);
    void deleteUser(Long id);

    List<User> listAll();
}
