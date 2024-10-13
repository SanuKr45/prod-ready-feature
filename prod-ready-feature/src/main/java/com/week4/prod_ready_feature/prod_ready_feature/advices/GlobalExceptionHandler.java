package com.week4.prod_ready_feature.prod_ready_feature.advices;

import com.week4.prod_ready_feature.prod_ready_feature.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiErrors> handlesResourceNotFoundException(ResourceNotFound exception){
        ApiErrors apiErrors = new ApiErrors(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiErrors, HttpStatus.NOT_FOUND);
    }


}
