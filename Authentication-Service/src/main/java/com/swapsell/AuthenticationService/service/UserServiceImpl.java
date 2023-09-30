package com.swapsell.AuthenticationService.service;

import com.swapsell.AuthenticationService.domain.User;
import com.swapsell.AuthenticationService.exception.UserAlreadyExistsException;
import com.swapsell.AuthenticationService.exception.UserDoesNotExistsException;
import com.swapsell.AuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        Optional<User> userWithEmailId = userRepository.findByEmail(user.getEmail());
        if (userWithEmailId.isPresent()){
            throw new UserAlreadyExistsException("This user is already taken try other");
        }
        return userRepository.save(user);
    }

    @Override
    public User UserLogIn(User user) throws UserDoesNotExistsException {
        Optional<User> userWithEmailId = userRepository.findByEmail(user.getEmail());
        User existingUer = null;
        if (userWithEmailId.isPresent()){
             existingUer = userWithEmailId.get();
        }
        if (existingUer==null){
            throw new UserDoesNotExistsException("User does not exists");
        }
      return existingUer;
    }

    @Override
    public Optional<User> userByEmailId(String emailId) {
        return  userRepository.findByEmail(emailId);

    }

    @Override
    public User findUserByEmailAndPassWord(String email, String password) throws UserDoesNotExistsException {
        Optional<User> userWithEmailAndPassword = userRepository.findByEmailAndPassword(email, password);
        if (userWithEmailAndPassword.isPresent()){
         return userWithEmailAndPassword.get();
        }else {
            throw new UserDoesNotExistsException("email or password is wrong");
        }
    }
}
