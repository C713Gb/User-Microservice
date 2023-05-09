package com.gbeedev.userservice.exceptions;

public class MissingFieldsException extends RuntimeException{

    //extra properties that you want to manage
    public MissingFieldsException(){
        super("Missing fields !!");
    }

    public MissingFieldsException(String message){
        super(message);
    }

}
