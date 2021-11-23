package com.publit.api;

import com.publit.api.data.UserRegistrationRequest;
import com.publit.api.data.UserRegistrationResponse;
import com.publit.domain.HelloService;
import com.publit.domain.UserInfo;
import org.springframework.web.bind.annotation.*;

/**
 * Класс который обслуживает веб-запросы.
 */
@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/api/v1/hello")
    public String hello(@RequestParam String name) {
        return helloService.hello(name);
    }

    @PostMapping("/api/v1/register")
    public UserRegistrationResponse registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        return new UserRegistrationResponse(
                helloService.registerUser(registrationRequestToInfo(registrationRequest)) ? "ОК" : "FAIL",
                "Test message"
        );
    }
    private UserInfo registrationRequestToInfo (UserRegistrationRequest request) {
        return new UserInfo(request.getUsername(),
                request.getEmail(),
                request.getPassword());
    }
}
