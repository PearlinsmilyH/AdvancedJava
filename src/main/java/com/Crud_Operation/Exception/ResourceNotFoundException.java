package com.Crud_Operation.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String error){
        super(error);
    }
}
