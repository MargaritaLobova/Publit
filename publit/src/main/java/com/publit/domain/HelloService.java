package com.publit.domain;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String hello(String name) {
        return "Hello " + name;
    }

    public boolean registerUser(UserInfo userInfo) {
        return true;
    }
}
