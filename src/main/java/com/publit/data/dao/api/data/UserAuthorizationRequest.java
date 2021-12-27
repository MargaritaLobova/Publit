package com.publit.data.dao.api.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAuthorizationRequest {
    private String email;
    private String password;
}
