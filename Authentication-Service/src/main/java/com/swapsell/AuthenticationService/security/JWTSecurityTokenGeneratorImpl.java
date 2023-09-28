package com.swapsell.AuthenticationService.security;

import com.swapsell.AuthenticationService.domain.UserLogIn;

import java.util.HashMap;
import java.util.Map;

public class JWTSecurityTokenGeneratorImpl implements JWTSecurityTokenGenerator {
    @Override
    public Map<String, String> generateJWTToken(UserLogIn userLogIn) {
        Map<String,String> token = new HashMap<>();
        return null;
    }
}
