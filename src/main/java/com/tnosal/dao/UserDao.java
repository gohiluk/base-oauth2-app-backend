package com.tnosal.dao;

import com.tnosal.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by gohilukk on 2015-11-11.
 */
@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public User findByEmail(String email) {
        return entityManager.createQuery("SELECT i from User i where i.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public User findByUsernameCaseInsensitive(String username) {
        return (User) entityManager.createQuery(
                "select i from User i where i.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }
}
