package com.tnosal.dao;

import com.tnosal.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by gohilukk on 2015-11-11.
 */
@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }

    public void addUser(User user) {
        getSessionFactory().save(user);
    }

    public User findByEmail(String email) {
        Criteria criteria = getSessionFactory().createCriteria(User.class);
        criteria.add(Expression.eq("email", email));
        List list = criteria.list();
        if (list != null) {
            return (User)list.get(0);
        }
        return null;
    }

    public User findByUsernameCaseInsensitive(String username) {
        Criteria criteria = getSessionFactory().createCriteria(User.class);
        criteria.add(Expression.eq("username", username));
        List list = criteria.list();
        if (list != null) {
            return (User)list.get(0);
        }
        return null;
    }
}
