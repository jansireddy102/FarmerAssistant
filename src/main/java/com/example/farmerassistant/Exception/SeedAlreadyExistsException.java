package com.example.farmerassistant.Exception;

public class SeedAlreadyExistsException extends RuntimeException{
    private String message;

    public SeedAlreadyExistsException(){};
    public SeedAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }
}
