package com.example.application.services;

import com.example.application.dto.InputDtoUser;
import com.example.application.dto.OutputDtoUser;
import com.example.application.entities.User;
import com.example.application.mapper.UserMapperImp;
import com.example.application.repositories.UserRepository;
import com.example.application.services.interfaces.UserService;
import com.example.application.utils.MapperUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.MappingException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Анотация логирования лабка
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapperImp userMapperImp;

    /**
     * Метод для добавления пользователя в базу
     *
     * @param inputDtoUser dto получаемое от пользователя
     * @return возвращает пользователя в базу благодаря JPA репозитория
     * @throws JsonProcessingException
     */
    @Override
    public User addUser(InputDtoUser inputDtoUser) { //TODO вывод полученой dto на уровне контролера
        //логирование из библиотеке ламбок
        try {
            log.info("Добавляем пользователя \n{}", MapperUtils.MAPPER.writeValueAsString(inputDtoUser));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("Ошибка маппинга inputDtoUser");
        }
        return userRepository.save(userMapperImp.toUser(inputDtoUser));
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Удаление пользователя по id " + id.toString() + "\n{}");
        userRepository.deleteById(id);
    }

    //TODO разобратся с оптионалом
    @Override
    public Optional<User> getById(InputDtoUser inputDtoUser) {
        try {
            log.info("Получение пользователя пользователя \n{}", MapperUtils.MAPPER.writeValueAsString(inputDtoUser));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("Ошибка маппинга inputDtoUser");
        }
        return Optional.empty();

        //return Optional.of(userRepository.findById(inputDtoUser.getId()));
    }

    //ПОолучения списка пользователей по имени
    @Override
    public List<OutputDtoUser> getByName(InputDtoUser inputDtoUser) {
        log.info("Получение пользователей по именам \n{}");
        return userRepository.findByName(inputDtoUser.getName()).stream()
                .map(s -> userMapperImp.toDto(s))
                .collect(Collectors.toList());
    }

    //Получение списка пользователей по фамилии
    @Override
    public List<OutputDtoUser> getByLastname(InputDtoUser inputDtoUser) {
        log.info("Получение пользователей по фамили \n{}");
        return userRepository.findByLastName(inputDtoUser.getLastName()).stream()
                .map(s -> userMapperImp.toDto(s))
                .collect(Collectors.toList());
    }

    //Получение списка пользователей по возрасту
    @Override
    public List<OutputDtoUser> getByAge(InputDtoUser inputDtoUser) {
        log.info("Получение пользователей по возрасту \n{}");
        return userRepository.findByAge(inputDtoUser.getAge()).stream()
                .map(s -> userMapperImp.toDto(s))
                .collect(Collectors.toList());
    }

    //Получение полного списка пользователей
    @Override
    public List<OutputDtoUser> getAll() {
        log.info("Полуение всех пользователей \n{}");
        return userRepository.findAll().stream()
                .map(s -> userMapperImp.toDto(s))
                .collect(Collectors.toList());
    }
}
