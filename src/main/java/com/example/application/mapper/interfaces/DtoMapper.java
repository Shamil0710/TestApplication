package com.example.application.mapper.interfaces;

import com.example.application.dto.InputDtoUser;
import com.example.application.dto.OutputDtoUser;
import com.example.application.entities.User;

public interface DtoMapper {

    OutputDtoUser toDto(User user);
}
