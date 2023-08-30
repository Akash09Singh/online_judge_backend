package com.spoj.online_judge.exception.customExceptiom;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
