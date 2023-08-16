package com.OnlineBookStore.OnlineBookStore.exceptions;

public class userNotFoundException extends RuntimeException{

    public userNotFoundException(Long userId){
        super("User with Id " + userId + " not found");
    }

}
