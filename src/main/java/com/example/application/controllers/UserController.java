package com.example.application.controllers;


import com.example.application.dto.OutputDtoUser;
import com.example.application.entities.User;
import com.example.application.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<OutputDtoUser> readAll() {
        final List<OutputDtoUser> all = userService.getAll();

    }


}
