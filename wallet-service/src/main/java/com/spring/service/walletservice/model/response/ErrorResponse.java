package com.spring.service.walletservice.model.response;

public class ErrorResponse extends Response{

    public ErrorResponse(String message) {
        super(false, message);
    }
}