package com.example.application.services.interfaces;

import com.example.application.dto.InputDtoUser;
import com.example.application.dto.OutputDtoUser;
import com.example.application.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(InputDtoUser inputDtoUser) throws JsonProcessingException;
    void deleteById(Integer id) throws JsonProcessingException;
    Optional<User> getById(InputDtoUser inputDtoUser) throws JsonProcessingException;
    List<OutputDtoUser> getByName(InputDtoUser inputDtoUser);
    List<OutputDtoUser> getByLastname(InputDtoUser inputDtoUser);
    List<OutputDtoUser> getByAge(InputDtoUser inputDtoUser);
    List<OutputDtoUser> getAll();
}
