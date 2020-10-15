package com.example.microservice.exception;


import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.ws.rs.InternalServerErrorException;
import java.util.Date;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InterruptedException.class)
    public ResponseEntity<?> handleInterruptedException (InterruptedException e, WebRequest r) {
        return common(e) ;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MyCustomErrorAttributes> handleRunTimeException(RuntimeException ex) {
        return common(ex) ;

    }
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<MyCustomErrorAttributes> handleResourceNotFound(InternalServerErrorException ex) {
       return common(ex) ;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyCustomErrorAttributes> handleGlobal(InternalServerErrorException ex) {
        return common(ex) ;
    }

    private ResponseEntity<MyCustomErrorAttributes> common(Exception e) {
        MyCustomErrorAttributes response = new MyCustomErrorAttributes();
        response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setErrorMessage(e.getMessage());
        log.debug(e.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }


}
