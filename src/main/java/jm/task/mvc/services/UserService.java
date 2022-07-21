package jm.task.mvc.services;

import jm.task.mvc.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public User getUserById(Long id);

    public void editUser(User user);
    public void deleteUser(Long id);

    public List<User> listAll();
}
