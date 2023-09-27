package com.swapsell.AuthenticationService.service;

import com.swapsell.AuthenticationService.domain.User;
import com.swapsell.AuthenticationService.exception.UserAlreadyExistsException;
import com.swapsell.AuthenticationService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        Optional<User> userWithEmailId = userRepository.findByEmail(user.getEmail());
        if (userWithEmailId.isPresent()){
            throw new UserAlreadyExistsException("user already present with this id");
        }

        return userRepository.save(user);
    }
}
