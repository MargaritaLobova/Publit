package com.publit.domain;

import com.publit.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService {
    public User authenticateUser(UserRepo userRepo, String username, String password) {
        //TODO search for the appropriate user
        return (User) userRepo.findByUsername(username);
    }
    public boolean isCorrectAuthentication(UserRepo userRepo, String username, String password) {
        //TODO authentication logic
        return true;
    }
}
