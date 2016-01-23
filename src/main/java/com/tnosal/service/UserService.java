package com.tnosal.service;

import com.tnosal.dao.UserDao;
import com.tnosal.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gohilukk on 2016-01-14.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User loadUserByUsername(final String username) {
        return userDao.findByUsernameCaseInsensitive(username);
    }
}
