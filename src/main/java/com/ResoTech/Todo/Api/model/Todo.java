package com.ResoTech.Todo.Api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    private Integer todoId;
    private String todoName;
    private boolean todoStatus;
    private String todoDescription;

//    @ManyToOne()
//    @JoinColumn(name = "fk_user_id")
//    User user;
}
