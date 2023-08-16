package com.OnlineBookStore.OnlineBookStore.exceptions;

public class bookNotFounException extends RuntimeException{
    public bookNotFounException(Long bookId){
        super("Book with Id " + bookId + " not found or Out of Stock");
    }
}
