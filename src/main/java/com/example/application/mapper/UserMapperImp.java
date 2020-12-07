package com.example.application.mapper;

import com.example.application.dto.InputDtoUser;
import com.example.application.dto.OutputDtoUser;
import com.example.application.entities.User;
import com.example.application.mapper.interfaces.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImp implements UserMapper {

    //Метод конвертации из входящего дто в сущность
    public OutputDtoUser toDto (User user) {
        return new OutputDtoUser(user.getId(), user.getName(), user.getLastName(), user.getAge());
    }

    //Метод конвертации из сущности в ихсодящее дто
    public User toUser(InputDtoUser inputDtoUser) {
        return new User(inputDtoUser.getName(), inputDtoUser.getLastName(), inputDtoUser.getAge());
    }
}
