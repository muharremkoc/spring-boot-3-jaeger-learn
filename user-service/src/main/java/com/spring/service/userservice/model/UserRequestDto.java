package com.spring.service.userservice.model;

public class UserRequestDto {

    private String username;

    public UserRequestDto() {
    }

    public UserRequestDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
