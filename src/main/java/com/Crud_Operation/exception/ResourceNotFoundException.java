package com.Crud_Operation.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String error){
        super(error);
    }
}
