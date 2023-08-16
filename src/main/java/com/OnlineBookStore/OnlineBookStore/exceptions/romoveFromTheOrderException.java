package com.OnlineBookStore.OnlineBookStore.exceptions;

import java.util.List;

public class romoveFromTheOrderException extends RuntimeException{
    public romoveFromTheOrderException(List<Long> bookIds){
        super("Remove this list of Ids - "+ bookIds.toString());
    }
}
