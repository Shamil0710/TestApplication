package com.example.application.repositories;

import com.example.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
//
//    Optional<User> findById(Integer id);
//
//    Optional<User> findByName(String name);
//

    List<User> findByName(String name);
    List<User> findByLastName(String lastName);
    List<User> findByAge(Integer age);
}
