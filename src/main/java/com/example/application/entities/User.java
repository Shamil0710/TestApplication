package com.example.application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

//TODO: Это сущность(entity)
@Data
@AllArgsConstructor
public class User {

   private String name;
   private String secondName;
   private Integer age;
   private Integer id;

}
