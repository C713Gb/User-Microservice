package com.gbeedev.userservice.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{

    //extra properties that you want to manage
    public EmailAlreadyExistsException(){
        super("Email already exists on server !!");
    }

    public EmailAlreadyExistsException(String message){
        super(message);
    }

}
