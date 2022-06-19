package com.publit.domain;

import com.publit.data.dao.api.repos.UserRepo;
import com.publit.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public String registerUser(User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("You are already registered!");
        } else {
            user.setToken(getRandomString());//TODO improve token implementation
            userRepo.save(user);
            return user.getToken();
        }
    }

    public String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(50);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    @Transactional
    public User authorizeUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("There is no such a user with such an email!");
        } else {
            if (user.getPassword().equals(password)) {
                user.setToken(getRandomString());//TODO improve token implementation
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

    @Transactional
    public void deleteUser(User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("You are already registered!");
        } else {
            userRepo.deleteById(user.getId());
        }
    }
}
