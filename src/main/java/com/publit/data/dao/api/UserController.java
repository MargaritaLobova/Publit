package com.publit.data.dao.api;

import com.publit.data.dao.api.data.UserAuthorizationRequest;
import com.publit.data.dao.api.data.UserAuthorisationResponse;
import com.publit.data.dao.api.data.UserRegistrationRequest;
import com.publit.data.dao.api.data.UserRegistrationResponse;
import com.publit.data.model.User;
import com.publit.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/register")
    public UserRegistrationResponse registerUser(@RequestBody UserRegistrationRequest registerRequest) {
        User user = registerRequestToUser(registerRequest);
        return new UserRegistrationResponse(userService.registerUser(user));
    }

    @PostMapping("/api/v1/auth")
    public UserAuthorisationResponse authoriseUser(@RequestBody UserAuthorizationRequest authenticationRequest) {
        User user = userService.authorizeUser(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        return new UserAuthorisationResponse(user.getToken());
    }

    @PostMapping("/api/v1/out")
    public void logout(@RequestHeader(name = "Authorization") String token) {
        userService.logout(token);
    }

    private User registerRequestToUser(UserRegistrationRequest request) {
        return new User(request.getUsername(),
                request.getEmail(),
                request.getPassword());
    }
}

