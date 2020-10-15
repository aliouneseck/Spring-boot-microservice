package com.example.microservice.exception;

import lombok.Data;


@Data
public class MyCustomErrorAttributes {

    private int errorCode;
    private String errorMessage;



}
