package jm.task.mvc.dao;

import jm.task.mvc.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getResultList()
                .stream().findAny().orElse(null);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = getUserById(id);
        entityManager.remove(user);
        entityManager.flush();
    }

    @Override
    @Transactional
    public List<User> listAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
