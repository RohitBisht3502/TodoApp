package com.ResoTech.Todo.Api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;

    @Email
    @NotNull(message = "email is required")
    private String userEmail;

   @NotNull(message = "Password should be strong")
    private String userPassword;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Gender is required")
    private Gender userGender;

//    @OneToMany(mappedBy = "user")
//    List<Todo> todos;
}
