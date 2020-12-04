package com.example.application.services.interfaces;

import com.example.application.dto.InputDtoUser;
import com.example.application.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(InputDtoUser inputDtoUser);
    void delete (InputDtoUser inputDtoUser);
    Optional<User> getById(InputDtoUser inputDtoUser);
    List<User> getByName(InputDtoUser inputDtoUser);
    List<User> getByLastname(InputDtoUser inputDtoUser);
    List<User> getByAge(InputDtoUser inputDtoUser);
    List<User> getAll();
}
