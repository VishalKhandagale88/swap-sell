package com.swapsell.AuthenticationService.service;

import com.swapsell.AuthenticationService.domain.User;
import com.swapsell.AuthenticationService.exception.UserAlreadyExistsException;
import com.swapsell.AuthenticationService.exception.UserDoesNotExistsException;
import org.springframework.stereotype.Service;


public interface UserService {
    User saveUser(User user) throws UserAlreadyExistsException;
    User UserLogIn(String email) throws UserDoesNotExistsException;
}
