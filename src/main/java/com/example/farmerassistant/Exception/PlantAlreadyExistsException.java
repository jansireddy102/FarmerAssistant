package com.example.farmerassistant.Exception;

public class PlantAlreadyExistsException extends RuntimeException{
    private String message;

    public PlantAlreadyExistsException(){};

    public PlantAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }

}

