package com.tnosal.binder;

import com.tnosal.domain.User;
import com.tnosal.model.UserDTO;

/**
 * Created by gohilukk on 2015-12-14.
 */
public class UserBinder {

    public static User bindUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getEmail());
        return user;
    }
}
