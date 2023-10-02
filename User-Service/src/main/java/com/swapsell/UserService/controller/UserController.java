package com.swapsell.UserService.controller;

import com.swapsell.UserService.domain.User;
import com.swapsell.UserService.exception.UserAlreadyExistsException;
import com.swapsell.UserService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @PostMapping("user/register")
    public ResponseEntity<?> registerUser(User user){
        try {
            User registeredUserToApplication = userService.registerUserToApplication(user);
            return new ResponseEntity<>(registeredUserToApplication,HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}