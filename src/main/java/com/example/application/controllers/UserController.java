package com.example.application.controllers;


import com.example.application.dto.InputDtoUser;
import com.example.application.dto.OutputDtoUser;
import com.example.application.entities.User;
import com.example.application.services.interfaces.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<OutputDtoUser>> readAll() {
        final List<OutputDtoUser> all = userService.getAll();

        return all != null && !all.isEmpty()
                ? new ResponseEntity<>(all, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //TODO обработать на месте в кетч возрачать ошибку 500
    @GetMapping(value = "/users_string")
    public ResponseEntity<String> readAllString() throws JsonProcessingException {
        final List<OutputDtoUser> all = userService.getAll();
        ObjectMapper objectMapper = new ObjectMapper();

        return all != null && !all.isEmpty()
                ? new ResponseEntity<>(objectMapper.writeValueAsString(all), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //TODO написать валидацию
    @PutMapping(value = "/users/add")
    public ResponseEntity<Integer> addUser(@RequestBody InputDtoUser inputDtoUser) throws JsonProcessingException {
        final User user = userService.addUser(inputDtoUser);
        return ResponseEntity.ok(user.getId());
    }


}
