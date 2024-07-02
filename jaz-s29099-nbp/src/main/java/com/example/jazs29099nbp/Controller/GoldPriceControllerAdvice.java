package com.example.jazs29099nbp.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GoldPriceControllerAdvice {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> HandleNotFoundException(HttpClientErrorException.NotFound ex) {
        return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> HandleBadRequestException(HttpClientErrorException.BadRequest ex) {
        String message = ex.getMessage();
        if (message != null && message.contains("Exceeded the limit")) {
            return new ResponseEntity<>("Exceeded the limit", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> HandleGenericExceptionException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
