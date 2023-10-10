package com.swapsell.UserService.service;

import com.swapsell.UserService.configuration.MessageConfiguration;
import com.swapsell.UserService.domain.Product;
import com.swapsell.UserService.domain.User;
import com.swapsell.UserService.domain.UserDTO;
import com.swapsell.UserService.exception.ProductsDoesNotExistsException;
import com.swapsell.UserService.exception.UserAlreadyExistsException;
import com.swapsell.UserService.exception.UserDoesNotExistsException;
import com.swapsell.UserService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @RabbitListener(queues = MessageConfiguration.queueName1)
    public void userDataFromAuthService(UserDTO user) throws UserAlreadyExistsException{
        String userEmail = user.getEmail();
        String userLastName = user.getLastName();
        String firstName = user.getFirstName();
        User newUser = new User();
        newUser.setEmail(userEmail);
        newUser.setLastName(userLastName);
        newUser.setFirstName(firstName);
        registerUserToApplication(newUser);
    }
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
        User existingUser ;
        if (userByEmail.isPresent()){
             existingUser = userByEmail.get();
            if (user.getEmail()!=null){
                existingUser.setEmail(user.getEmail());
            }
            if (user.getAddress()!=null){
                existingUser.setAddress(user.getAddress());
            }
            if (user.getFirstName()!=null){
                existingUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName()!=null){
                existingUser.setLastName(user.getLastName());
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

            userRepository.save(existingUser);
        }else {
            throw new UserDoesNotExistsException("user with "+user.getEmail()+" does not exists");
        }

        return user;

    }

    @Override
    public User getUserInformation(String email) throws UserDoesNotExistsException {
        Optional<User> userByEmail = userRepository.findUserByEmail(email);
        if (userByEmail.isPresent()){
            return userByEmail.get();
        }else {
            throw new UserDoesNotExistsException("User with "+email+" is not found");
        }
    }

    @Override
    public boolean removeUserFromDb(String emailId) throws UserDoesNotExistsException {
        Optional<User> userByEmail = userRepository.findUserByEmail(emailId);
        if (userByEmail.isPresent()){
            userRepository.delete(userByEmail.get());
            return true;
        }else {
            throw new UserDoesNotExistsException("user does not exists with "+emailId+" this email");
        }
    }

    @Override
    public User postAnAdd(String emailId, Product product) throws UserDoesNotExistsException {
        Optional<User> userByEmail = userRepository.findUserByEmail(emailId);
        User user;
        LocalDateTime localDateTime = LocalDateTime.now();
        product.setAddPostedOnDate(localDateTime);
        if (userByEmail.isPresent()){
            user = userByEmail.get();
            List<Product> products = user.getProducts();
            if (products==null){
                // will create a product list
                user.setProducts(Collections.singletonList(product));
            }else {
                products.add(product);
                user.setProducts(products);
            }
        }else {
            throw new UserDoesNotExistsException("User does not found with "+emailId+" id");
        }
        userRepository.save(user);
        return user;

    }

    @Override
    public User removeProductsFromProductsList(String emailId, Long productId) throws UserDoesNotExistsException, ProductsDoesNotExistsException {
        Optional<User> userByEmail = userRepository.findUserByEmail(emailId);
        User user;
        if (userByEmail.isPresent()){
            user = userByEmail.get();
            List<Product> productList = user.getProducts();
            Optional<Product> optionalProduct = productList.stream().filter(searchItem -> Objects.equals(searchItem.getId(), productId)).findAny();
            if (optionalProduct.isPresent()){
                productList.remove(optionalProduct.get());
                user.setProducts(productList);
            }else{
                throw new ProductsDoesNotExistsException("Product is not available with "+productId);
            }
        }else {
            throw new UserDoesNotExistsException("No user found with "+emailId);
        }
        userRepository.save(user);
        return user;

    }
}
