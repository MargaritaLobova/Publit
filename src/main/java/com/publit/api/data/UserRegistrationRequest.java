package com.publit.api.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationRequest {
    @JsonProperty(value = "user_name")
    private String username;
    private String password;
    private String email;

}