package com.example.application.entities;

import lombok.*;

import javax.persistence.*;


//TODO: Это сущность(entity)
//аннотация, регистрирующая класс как сущность БД
@Entity
//связываем с конкретной таблицей по названию
@Table(catalog = "Users", name = "users")
@Data
@NoArgsConstructor
public class User {

    //указывает на то, что следующее поле является ID и будет использоваться для поиска по умолчанию
    @Id
    //название таблицы в БД
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "age")
    private Integer age;


    public User(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
