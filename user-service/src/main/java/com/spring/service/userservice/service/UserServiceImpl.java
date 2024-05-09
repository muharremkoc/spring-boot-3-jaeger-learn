package com.spring.service.userservice.service;

import com.spring.service.userservice.domain.User;
import com.spring.service.userservice.exceptions.UserNotFoundException;
import com.spring.service.userservice.model.UserRequestDto;
import com.spring.service.userservice.repository.UserRepository;
import io.micrometer.tracing.annotation.NewSpan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    Logger log= LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserRequestDto userRequestDto) {
        User newUser = new User();
        newUser.setUsername(userRequestDto.getUsername());
        log.info("User was create Successfully");
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        log.info("Get Users Successfully");
        return userRepository.findAll();
    }

    @Override
    @NewSpan(value = "user-service-get-user-span")
    public User getUserById(Integer id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found with Id: "+id));
    }

    @Override
    public User updateUser(Integer id, UserRequestDto userRequestDto) throws UserNotFoundException {
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found with Id: "+id));
        user.setUsername(userRequestDto.getUsername());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) throws UserNotFoundException {
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found with Id: "+id));
        userRepository.delete(user);
    }
}
