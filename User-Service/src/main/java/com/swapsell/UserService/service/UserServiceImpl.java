package com.swapsell.UserService.service;

import com.swapsell.UserService.domain.User;
import com.swapsell.UserService.exception.UserAlreadyExistsException;
import com.swapsell.UserService.exception.UserDoesNotExistsException;
import com.swapsell.UserService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUserToApplication(User user) throws UserAlreadyExistsException {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail.isPresent()){
            throw new UserAlreadyExistsException("user with "+user.getEmail()+" is already present");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUserData(User user) throws UserDoesNotExistsException {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail.isPresent()){
            User existingUser = userByEmail.get();
            if (user.getEmail()!=null){
                existingUser.setEmail(user.getEmail());
            }
            if (user.getAddress()!=null){
                existingUser.setAddress(user.getAddress());
            }
            if (user.getFirstName()!=null){
                existingUser.setFirstName(user.getFirstName());
            }
            if (user.getPhoneNumber()!=null){
                existingUser.setPhoneNumber(user.getPhoneNumber());
            }
            if (user.getCity()!=null){
                existingUser.setCity(user.getCity());
            }
            if (user.getPinCode()!=0){
                existingUser.setPinCode(user.getPinCode());
            }
            if (user.getGender()!=null){
                existingUser.setGender(user.getGender());
            }
            if (user.getImage()!=null){
                existingUser.setImage(user.getImage());
            }
        }else {
            throw new UserDoesNotExistsException("user with "+user.getEmail()+" does not exists");
        }
        return user;

    }
}
