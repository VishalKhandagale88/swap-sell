package com.swapsell.AuthenticationService.service;

import com.swapsell.AuthenticationService.domain.User;
import com.swapsell.AuthenticationService.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Service;


public interface UserService {
    User saveUser(User user) throws UserAlreadyExistsException;
}
