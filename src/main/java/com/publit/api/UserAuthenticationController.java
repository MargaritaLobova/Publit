package com.publit.api;

import com.publit.domain.UserAuthenticationService;
import com.publit.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthenticationController {
    @Autowired
    private UserAuthenticationService userAuthenticationService;
    @Autowired
    private UserRepo userRepo;
    /*@PostMapping("/api/v1/auth")
    public UserRegistrationResponse authUser(@RequestBody UserAuthenticationRequest registerRequest) {
        if (userAuthenticationService.authenticateUser(userRepo, registerRequest.getEmail(), registerRequest.getPassword())) {
            return new UserRegistrationResponse("OK",
                    "User "+user.getUsername()+" was successfully authenticated!");
        } else {
            return new UserRegistrationResponse("Failed", "Failed to register user");
        }
    }*/
}
