package com.example.farmerassistant.Exception;

public class PlanterNotFound extends RuntimeException {
    public PlanterNotFound(String message) {
        super(message);
    }
}
