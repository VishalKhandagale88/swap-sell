package com.swapsell.AuthenticationService.exception;

public class UserDoesNotExistsException extends Exception{
    public UserDoesNotExistsException(String message) {
        super(message);
    }
}
