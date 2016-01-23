package com.tnosal.binder;

import com.tnosal.domain.User;
import com.tnosal.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by gohilukk on 2015-12-14.
 */
public class UserBinder {

    public static User bindUser(UserDTO userDTO, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUsername(userDTO.getEmail());
        return user;
    }
}
