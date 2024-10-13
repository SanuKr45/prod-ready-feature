package com.week4.prod_ready_feature.prod_ready_feature.exceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message) {
        super(message);
    }
}
