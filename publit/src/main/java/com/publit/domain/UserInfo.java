package com.publit.domain;

import lombok.Value;

@Value
public class UserInfo {
    String username;
    String password;
    String email;
}
