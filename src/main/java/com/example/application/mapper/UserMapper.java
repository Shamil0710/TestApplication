package com.example.application.mapper;

import com.example.application.dto.InputDtoUser;
import com.example.application.dto.OutputDtoUser;
import com.example.application.entities.User;
import com.example.application.mapper.interfaces.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements DtoMapper, com.example.application.mapper.interfaces.UserMapper {

    public OutputDtoUser toDto (User user) {
        return new OutputDtoUser(user.getId(), user.getName(), user.getLastName(), user.getAge());
    }



    public User toUser(InputDtoUser inputDtoUser) {
        return new User(inputDtoUser.getId(), inputDtoUser.getName(), inputDtoUser.getLastName(), inputDtoUser.getAge());
    }
}
