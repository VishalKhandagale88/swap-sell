package com.swapsell.UserService.service;

import com.swapsell.UserService.domain.Product;
import com.swapsell.UserService.domain.User;
import com.swapsell.UserService.exception.ProductsDoesNotExistsException;
import com.swapsell.UserService.exception.UserAlreadyExistsException;
import com.swapsell.UserService.exception.UserDoesNotExistsException;

public interface UserService {
    User registerUserToApplication(User user) throws UserAlreadyExistsException;
    User updateUserData(User user) throws UserDoesNotExistsException;
    User getUserInformation(String email) throws UserDoesNotExistsException;
    boolean removeUserFromDb(String emailId) throws  UserDoesNotExistsException;
    User postAnAdd(String emailId, Product product) throws UserDoesNotExistsException;
    User removeProductsFromProductsList(String emailId,Long productId) throws UserDoesNotExistsException, ProductsDoesNotExistsException;
}
