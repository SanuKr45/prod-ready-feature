package com.week4.prod_ready_feature.prod_ready_feature.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

//    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timeStamp;
    private T data;
    private ApiErrors error;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
        System.out.println("hello");
    }

    public ApiResponse(ApiErrors error) {
        this();
        this.error = error;
    }

    public ApiResponse(T data) {
        this();
        this.data = data;

    }
}
