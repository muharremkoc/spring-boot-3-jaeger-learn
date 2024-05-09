package com.spring.service.userservice.controller;

import com.spring.service.userservice.domain.User;
import com.spring.service.userservice.exceptions.UserNotFoundException;
import com.spring.service.userservice.model.UserRequestDto;
import com.spring.service.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UserRequestDto userRequestDto) throws UserNotFoundException {
        return userService.updateUser(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) throws UserNotFoundException {
        userService.deleteUser(id);
    }
}
