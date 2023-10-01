package com.swapsell.UserService.service;

import com.swapsell.UserService.domain.User;
import com.swapsell.UserService.exception.UserAlreadyExistsException;

public interface UserService {
    User registerUserToApplication(User user) throws UserAlreadyExistsException;
}
