package com.publit.data.dao.api.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationRequest {
    @JsonProperty(value = "user_name")
    private String username;
    private String email;
    private String password;
}
