package com.tnosal.dao;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.tnosal.domain.QUser;
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
public class UserDao extends Dao{

    @PersistenceContext
    private EntityManager entityManager;

    public User findByEmail(String email) {
        return entityManager.createQuery("SELECT i from User i where i.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public User findByEmail2(String email) {
        QUser user = QUser.user;
        JPQLQuery query = new JPAQuery(entityManager);
        User u = query.from(user)
                .where(user.email.eq(email))
                .uniqueResult(user);
        return u;
    }

    public User findByUsernameCaseInsensitive(String username) {
        return (User) entityManager.createQuery(
                "select i from User i where i.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }
}
