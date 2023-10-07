package com.swapsell.UserService.controller;

import com.swapsell.UserService.domain.Product;
import com.swapsell.UserService.domain.User;
import com.swapsell.UserService.exception.UserAlreadyExistsException;
import com.swapsell.UserService.exception.UserDoesNotExistsException;
import com.swapsell.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("user/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUserToApplication = userService.registerUserToApplication(user);
            return new ResponseEntity<>(registeredUserToApplication, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("user/updateUserData")
    public ResponseEntity<?> updateUserData(@RequestBody User user) {
        try {
            User updatedUserData = userService.updateUserData(user);
            return new ResponseEntity<>(updatedUserData, HttpStatus.OK);
        } catch (UserDoesNotExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/user/userData/{email}")
    public ResponseEntity<?> fetchUserData(@PathVariable("email") String userEmailI){
        try {
            User userInformation = userService.getUserInformation(userEmailI);
            return  new ResponseEntity<>(userInformation,HttpStatus.OK);
        } catch (UserDoesNotExistsException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);

        }
    }

    @DeleteMapping("user/delete/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable("email") String userEmailId){
        try {
            boolean removeUserFromDb = userService.removeUserFromDb(userEmailId);
            return new ResponseEntity<>("user is removed",HttpStatus.OK);
        } catch (UserDoesNotExistsException e) {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);

        }
    }

    @PostMapping("user/product/{email}")
    public ResponseEntity<?> addProducts(@PathVariable("email") String email, @RequestBody Product product){
        try {
            User user = userService.postAnAdd(email, product);
            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (UserDoesNotExistsException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

}
