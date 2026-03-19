package ru.greenlight.springmvchibernate.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.greenlight.springmvchibernate.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional(readOnly = true)
    @Override
    @SuppressWarnings("unchecked")
    public List<User> showAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User showUserById(int id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь с id " + id + " не найден.");
        }
        return user;
    }

    @Transactional
    @Override
    public void updateUserById(int id, User updatedUser) {
        User userToBeUpdated = showUserById(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Transactional
    @Override
    public void deleteUserById(int id) {
        entityManager.remove(showUserById(id));
    }
}
