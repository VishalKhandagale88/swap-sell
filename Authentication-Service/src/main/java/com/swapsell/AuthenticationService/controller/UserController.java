package com.swapsell.AuthenticationService.controller;


import com.swapsell.AuthenticationService.domain.User;
import com.swapsell.AuthenticationService.domain.UserLogIn;
import com.swapsell.AuthenticationService.domain.UserResponse;
import com.swapsell.AuthenticationService.security.JWTSecurityTokenGenerator;
import com.swapsell.AuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTSecurityTokenGenerator jwtSecurityTokenGenerator;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/logIn")
    public ResponseEntity<?> userLogIn(@RequestBody UserLogIn userLogIn) {
        Map<String, String> token = new HashMap<>();
        if (userService.userByEmailId(userLogIn.getEmail()).isEmpty()) {
            token.put("message", "No user found");
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        if (userService.findUserByEmailAndPassWord(userLogIn.getEmail(), userLogIn.getPassword()).isEmpty()) {
            token.put("message", "Wrong credentials");
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        token = jwtSecurityTokenGenerator.generateJWTToken(userLogIn);
        return new ResponseEntity<>(token, HttpStatus.OK);

    }

    @GetMapping("/user/{email}")
    public ResponseEntity<?> getUserByEmailId(@PathVariable("email") String emailId) {
        Optional<User> userFromDb = userService.userByEmailId(emailId);
        if (userFromDb.isPresent()) {
            User existingUser = userFromDb.get();
            UserResponse userResponse = new UserResponse(existingUser.getId(), existingUser.getFirstName(), existingUser.getLastName(), existingUser.getEmail());
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("user with " + emailId + " email id not found", HttpStatus.NOT_FOUND);
        }
    }

}
