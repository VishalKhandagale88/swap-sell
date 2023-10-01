package com.swapsell.UserService.service;

import com.swapsell.UserService.domain.User;
import com.swapsell.UserService.exception.UserAlreadyExistsException;
import com.swapsell.UserService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUserToApplication(User user) throws UserAlreadyExistsException {

        return null;
    }
}
