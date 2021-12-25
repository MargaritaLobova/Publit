package com.publit.api.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAuthorizationRequest {
    private String email;
    private String password;
}
