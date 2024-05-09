package com.spring.service.userservice.model.response;

public class ErrorResponse extends Response{

    public ErrorResponse(String message) {
        super(false, message);
    }
}