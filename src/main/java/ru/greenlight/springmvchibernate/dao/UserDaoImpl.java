package ru.greenlight.springmvchibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.greenlight.springmvchibernate.models.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void addUsers() {
        Session session = sessionFactory.getCurrentSession();
        session.save(new User("Mike", 33, "mikle@gmail.com"));
        session.save(new User("John", 45, "dearjohn@gmail.com"));
        session.save(new User("Vasya", 23, "vasyanvasyanich@mail.ru"));
        session.save(new User("Jackson", 22, "jackasson@hotmail.com"));
        session.save(new User("Greg", 34, "gregory@gmail.com"));
    }

    @Transactional(readOnly = true)
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User showUserById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
