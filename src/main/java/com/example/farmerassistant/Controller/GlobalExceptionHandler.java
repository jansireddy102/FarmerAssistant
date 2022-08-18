package com.example.farmerassistant.Controller;
import com.example.farmerassistant.Exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(value = NoSuchSeedExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(NoSuchSeedExistsException ex) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = SeedAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(SeedAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = NoSuchPlantExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(NoSuchPlantExistsException ex) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = PlantAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(PlantAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = PlanterNotFound.class)
    public ResponseEntity<String> handelPlanterNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;


    }
}
