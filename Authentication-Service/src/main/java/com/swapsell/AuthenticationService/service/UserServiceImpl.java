package com.swapsell.AuthenticationService.service;

import com.swapsell.AuthenticationService.domain.User;
import com.swapsell.AuthenticationService.exception.UserAlreadyExistsException;
import com.swapsell.AuthenticationService.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        return null;
    }
}
