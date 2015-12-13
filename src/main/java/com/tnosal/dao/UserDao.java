package com.tnosal.dao;

import com.tnosal.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;

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
}
