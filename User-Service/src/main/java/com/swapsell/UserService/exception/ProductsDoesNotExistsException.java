package com.swapsell.UserService.exception;

public class ProductsDoesNotExistsException extends Exception{
    public ProductsDoesNotExistsException() {
    }
    public ProductsDoesNotExistsException(String message) {
        super(message);
    }
}
