package com.tnosal.service;

import com.tnosal.dao.AuthorityDao;
import com.tnosal.dao.UserDao;
import com.tnosal.model.Authority;
import com.tnosal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by gohilukk on 2015-12-13.
 */
@Service
public class RegisterService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorityDao authorityDao;

    public void setIdsForAuthorityIfExists(User user){
        for (Authority authority : user.getAuthorities()) {
            Optional<Long> roleUserId = authorityDao.getAuthorityIdByName(authority.getName());
            if (roleUserId.isPresent()) {
                authority.setId(roleUserId.get());
            }
        }

    }

    public void saveUser(User user) {
        userDao.addUser(user);
    }
}
