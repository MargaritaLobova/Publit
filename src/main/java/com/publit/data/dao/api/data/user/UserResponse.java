package com.publit.data.dao.api.data.user;

import lombok.Value;

@Value
public class UserResponse {
    String token;
    String status;
    String message;
}
