package com.example.application.controllers;

import com.example.application.entities.User;
import com.example.application.repositories.interfaces.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO переделать с учетом DTO

//Данный клас является контролером и будет обрабатывать логику клиентских запросов
@Controller
public class UserController {

    private final IRepository userRepository;

    //@Autowired Анотация говорит о необходимости внедрить зависимость
    @Autowired
    public UserController( @Qualifier("xui") IRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Данный метод обрабатывает POST запрос по адресу "/users"
     *
     * @RequestBody Говорит о том что параметор принимается из тела запроса
     * ResponseEntity возращает HTTP статус код, в данном случае CREATED
     */
    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        userRepository.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * @return Возращает список пользвоатель и статус "ОК" писок не пустой. Либо статус "NOT FOUND" если список пуст.
     * @GetMapping Обрабатывает GET запрос по адресу "/users"
     */
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> read() {
        final List<User> users = userRepository.readAll();

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * В данном случаи переменна указаная в имени пути передается с помощью анотации @PathVariable
     */
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") int id) {
        final User user = userRepository.read(id);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody User user) {
        final boolean updated = userRepository.update(user, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userRepository.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED)
                : new ResponseEntity<>(HttpStatus.OK);
    }

}
