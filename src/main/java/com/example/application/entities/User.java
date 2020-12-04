package com.example.application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//TODO: Это сущность(entity)
//аннотация, регистрирующая класс как сущность БД
@Entity
//связываем с конкретной таблицей по названию
@Table(catalog = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

   //указывает на то, что следующее поле является ID и будет использоваться для поиска по умолчанию
   @Id
   //название таблицы в БД
   @Column(name = "id")
   private Integer id;
   @Column(name = "name")
   private String name;
   @Column(name = "lastName")
   private String lastName;
   @Column(name = "age")
   private Integer age;


}
