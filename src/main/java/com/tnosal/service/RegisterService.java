package com.tnosal.service;

import com.tnosal.dao.AuthorityDao;
import com.tnosal.dao.UserDao;
import com.tnosal.domain.Authority;
import com.tnosal.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    public void setUserRole(User user) {
        Optional<Authority> role = authorityDao.getAuthorityByName(com.tnosal.constant.Authority.ROLE_USER);
        if (role.isPresent()) {
            Set<Authority> authorities = new HashSet<>();
            authorities.add(role.get());
            user.setAuthorities(authorities);
        }
    }


    public void saveUser(User user) {
        userDao.add(user);
    }
}
