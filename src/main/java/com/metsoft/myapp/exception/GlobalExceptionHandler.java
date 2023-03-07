package com.metsoft.myapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomException> handleExceptions(Exception exception, WebRequest webRequest){
        CustomException customException=new CustomException();
        customException.setPath(((ServletWebRequest)webRequest).getRequest().getRequestURI());
        customException.setMessage(exception.getMessage());
        customException.setDateTime(LocalDateTime.now());
        return new ResponseEntity<CustomException>(customException,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException exception){
        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName=((FieldError)error).getField();
            String errorMessage=error.getDefaultMessage();
            errorMap.put(fieldName,errorMessage);
        });
        return errorMap;
    }
}
