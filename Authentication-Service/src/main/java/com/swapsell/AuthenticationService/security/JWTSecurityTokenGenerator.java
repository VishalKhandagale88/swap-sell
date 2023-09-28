package com.swapsell.AuthenticationService.security;

import com.swapsell.AuthenticationService.domain.UserLogIn;

import java.util.Map;

public interface JWTSecurityTokenGenerator {
        Map<String ,String > generateJWTToken(UserLogIn userLogIn);
}
