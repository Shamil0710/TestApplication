package com.example.application.services;

import com.example.application.dto.InputDtoUser;
import com.example.application.entities.User;
import com.example.application.mapper.interfaces.UserMapper;
import com.example.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements com.example.application.services.interfaces.UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(InputDtoUser inputDtoUser) {
        User saveUser = userRepository.saveAndFlush(userMapper.toUser(inputDtoUser));
        return saveUser;
    }

    @Override
    public void delete(InputDtoUser inputDtoUser) {
        userRepository.deleteById(inputDtoUser.getId());
    }

    //TODO разобратся с оптионалом
    @Override
    public Optional<User> getById(InputDtoUser inputDtoUser) {
        return Optional.empty();

        //return Optional.of(userRepository.findById(inputDtoUser.getId()));
    }

    @Override
    public List<User> getByName(InputDtoUser inputDtoUser) {
        return userRepository.findByName(inputDtoUser.getName());
    }

    @Override
    public List<User> getByLastname(InputDtoUser inputDtoUser) {
        return userRepository.findByLastName(inputDtoUser.getLastName());
    }

    @Override
    public List<User> getByAge(InputDtoUser inputDtoUser) {
        return userRepository.findByAge(inputDtoUser.getAge());
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
