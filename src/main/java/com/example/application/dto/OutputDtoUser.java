package com.example.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OutputDtoUser {

    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
}
