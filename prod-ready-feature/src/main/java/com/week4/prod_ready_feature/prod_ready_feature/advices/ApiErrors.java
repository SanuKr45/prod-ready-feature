package com.week4.prod_ready_feature.prod_ready_feature.advices;


import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data

public class ApiErrors {

    private LocalDateTime timestamp;

    private String error;

    private HttpStatus statuscode;


    public ApiErrors() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiErrors(String error, HttpStatus statuscode) {
        this();
        this.error = error;
        this.statuscode = statuscode;
    }
}
