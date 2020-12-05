package com.example.application.services;

import com.example.application.dto.InputDtoUser;
import com.example.application.dto.OutputDtoUser;
import com.example.application.entities.User;
import com.example.application.mapper.UserMapper;
import com.example.application.repositories.UserRepository;
import com.example.application.services.interfaces.UserService;
import com.example.application.utils.MapperUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Анотация логирования лабка
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(InputDtoUser inputDtoUser) throws JsonProcessingException { //TODO вывод полученой dto на уровне контролера
        //логирование
      log.info("Добавляем пользователя \n{}", MapperUtils.MAPPER.writeValueAsString(inputDtoUser));
        return userRepository.save(userMapper.toUser(inputDtoUser));
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    //TODO разобратся с оптионалом
    @Override
    public Optional<User> getById(InputDtoUser inputDtoUser) {
        return Optional.empty();

        //return Optional.of(userRepository.findById(inputDtoUser.getId()));
    }

    @Override
    public List<OutputDtoUser> getByName(InputDtoUser inputDtoUser) {
        return userRepository.findByName(inputDtoUser.getName()).stream()
                .map(s -> userMapper.toDto(s))
                .collect(Collectors.toList());
    }

    @Override
    public List<OutputDtoUser> getByLastname(InputDtoUser inputDtoUser) {
        return userRepository.findByLastName(inputDtoUser.getLastName()).stream()
                .map(s -> userMapper.toDto(s))
                .collect(Collectors.toList());
    }

    @Override
    public List<OutputDtoUser> getByAge(InputDtoUser inputDtoUser) {
        return userRepository.findByAge(inputDtoUser.getAge()).stream()
                .map(s -> userMapper.toDto(s))
                .collect(Collectors.toList());
    }

    @Override
    public List<OutputDtoUser> getAll() {
        return userRepository.findAll().stream()
                .map(s -> userMapper.toDto(s))
                .collect(Collectors.toList());
    }
}
