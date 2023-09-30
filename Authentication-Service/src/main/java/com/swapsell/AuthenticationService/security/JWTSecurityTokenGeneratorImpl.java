package com.swapsell.AuthenticationService.security;

import com.swapsell.AuthenticationService.domain.UserLogIn;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class JWTSecurityTokenGeneratorImpl implements JWTSecurityTokenGenerator {
    @Override
    public Map<String, String> generateJWTToken(UserLogIn userLogIn) {
        Map<String,String> token = new HashMap<>();
        String jwtToken = Jwts.builder()
                .claim("email",userLogIn.getEmail())
                .setSubject(userLogIn.getEmail())
                .signWith(SignatureAlgorithm.HS256,"secretKey")
                .compact();
        token.put("token",jwtToken);
        token.put("message","Logged in successfully");
        token.put("email", userLogIn.getEmail());
        return token;
    }
}
