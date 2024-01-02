package com.ResoTech.Todo.Api.repo;

import com.ResoTech.Todo.Api.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITodoRepo extends JpaRepository<Todo,Integer> {
    List<Todo> findAllTodoByTodoStatus(Boolean todoStatus);
}
