package com.swapsell.AuthenticationService.service;

import com.swapsell.AuthenticationService.domain.User;
import com.swapsell.AuthenticationService.exception.UserAlreadyExistsException;
import com.swapsell.AuthenticationService.exception.UserDoesNotExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {
    User saveUser(User user) throws UserAlreadyExistsException;
    User UserLogIn(User user) throws UserDoesNotExistsException;
    Optional<User> userByEmailId(String emailId);
}
