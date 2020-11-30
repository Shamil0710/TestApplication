package com.example.application.services;

import com.example.application.dto.DtoUser;
import com.example.application.entities.User;
import com.example.application.services.interfaces.IUserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements IUserMapper {

    public DtoUser toDto (User user) {
        return new DtoUser(user.getName(), user.getSecondName(), user.getAge());
    }
}
