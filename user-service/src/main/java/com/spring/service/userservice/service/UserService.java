package com.spring.service.userservice.service;

import com.spring.service.userservice.domain.User;
import com.spring.service.userservice.exceptions.UserNotFoundException;
import com.spring.service.userservice.model.UserRequestDto;

import java.util.List;

public interface UserService {

    User createUser(UserRequestDto userRequestDto);

    List<User> getUsers();

    User getUserById(Integer id) throws UserNotFoundException;

    User updateUser(Integer id, UserRequestDto userRequestDto) throws UserNotFoundException;

    void deleteUser(Integer id) throws UserNotFoundException;
}
