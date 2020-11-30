package com.example.application.services.interfaces;

import com.example.application.dto.DtoUser;
import com.example.application.entities.User;

public interface IUserMapper {

    DtoUser toDto (User user);
}
