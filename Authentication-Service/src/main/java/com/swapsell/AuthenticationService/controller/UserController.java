package com.swapsell.AuthenticationService.controller;


import com.swapsell.AuthenticationService.domain.User;
import com.swapsell.AuthenticationService.domain.UserResponse;
import com.swapsell.AuthenticationService.exception.UserAlreadyExistsException;
import com.swapsell.AuthenticationService.exception.UserDoesNotExistsException;
import com.swapsell.AuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try {
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/logIn")
    public ResponseEntity<?> userLogIn(@RequestBody User user){
        try {
            User userToLogIn = userService.UserLogIn(user);
            return new ResponseEntity<>(user,HttpStatus.OK);

        } catch (UserDoesNotExistsException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/user/{email}")
    public ResponseEntity<?> getUserByEmailId(@PathVariable("email") String emailId){
        Optional<User> userFromDb = userService.userByEmailId(emailId);
        if (userFromDb.isPresent()){
            User existingUser = userFromDb.get();
            UserResponse userResponse = new UserResponse(existingUser.getId(), existingUser.getFistName(), existingUser.getLastName(), existingUser.getEmail());
            return new  ResponseEntity<>(userResponse,HttpStatus.OK);
        }
    }

}
