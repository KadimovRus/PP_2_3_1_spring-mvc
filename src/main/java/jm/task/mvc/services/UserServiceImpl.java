package jm.task.mvc.services;

import jm.task.mvc.dao.UserDao;
import jm.task.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userService;


    @Override
    public void addUser(User user) {
        userService.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public void editUser(long id, User user) {
        userService.editUser(id, user);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @Override
    public List<User> listAll() {
        return userService.listAll();
    }
}
