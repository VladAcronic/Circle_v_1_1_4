package com.javalearn.circle.exceptions;

public class DataException extends Exception{

    public DataException (String message){
        super(message);
    }

    public DataException (String message, Throwable t){
        super(message, t);
    }

}
