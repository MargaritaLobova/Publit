package com.publit.api;

import com.publit.api.data.UserRegistrationRequest;
import com.publit.api.data.UserRegistrationResponse;
import com.publit.domain.User;
import com.publit.domain.UserRegistrationService;
import com.publit.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class UserRegistrationController {
    @Autowired
    private UserRegistrationService registrationService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/api/v1/register")
    public UserRegistrationResponse registerUser(@RequestBody UserRegistrationRequest registerRequest) {
        User user = registerRequestToUser(registerRequest);
        if (registrationService.registerUser(user)) {
            userRepo.save(user);
            return new UserRegistrationResponse("OK",
                    "User "+user.getUsername()+" was successfully registered!");
        } else {
            //TODO what happens if registration is not passed
            return new UserRegistrationResponse("Failed", "Failed to register user");
        }
    }

    @GetMapping("/api/v1/showAll")
    public void main() {
        System.out.println(userRepo.findAll());
    }

    private User registerRequestToUser(UserRegistrationRequest request) {
        return new User(request.getUsername(),
                request.getEmail(),
                request.getPassword());
    }
}

