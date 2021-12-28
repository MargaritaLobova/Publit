package com.publit.domain;

import com.publit.data.dao.repos.UserRepo;
import com.publit.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public String registerUser(User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("You are already registered!");
        } else {
            user.setToken(String.valueOf(user.getId()));//TODO improve token implementation
            userRepo.save(user);
            return user.getToken();
        }
    }

    @Transactional
    public User authorizeUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("There is no such a user with such an email!");
        } else {
            if (user.getPassword().equals(password)) {
                user.setToken(String.valueOf(user.getId()));//TODO improve token implementation
                return user;
            } else {
                throw new IllegalArgumentException("Not correct password");
            }
        }
    }

    @Transactional
    public void logout(String token) {
        userRepo.findByToken(token).setToken(null);
    }
}
