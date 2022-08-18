package com.example.farmerassistant.Exception;

public class NoSuchSeedExistsException extends RuntimeException {
    private String message;

    public NoSuchSeedExistsException() {
    }

    public NoSuchSeedExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
