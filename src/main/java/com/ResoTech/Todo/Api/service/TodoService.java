package com.ResoTech.Todo.Api.service;

import com.ResoTech.Todo.Api.model.Todo;
import com.ResoTech.Todo.Api.model.User;
import com.ResoTech.Todo.Api.model.dto.AuthenticationInputDto;
import com.ResoTech.Todo.Api.repo.ITodoRepo;
import com.ResoTech.Todo.Api.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    ITodoRepo todoRepo;

    @Autowired
    PTokenService pTokenService;

    @Autowired
    IUserRepo userRepo;

    public String postTodo(String email,String tokenValue,Todo todo) {

        if(pTokenService.authenticate(email,tokenValue)) {


            todoRepo.save(todo);
            return " todo Added";

        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public List<Todo> getAllTodos(String email,String tokenValue) {
        if(pTokenService.authenticate(email, tokenValue)) {
           return todoRepo.findAll();
        }
        else {
            return null;
        }
    }

    public String updateTodo(String email,String tokenValue, Integer todoId,Boolean todoStatus) {
        if(pTokenService.authenticate(email, tokenValue)) {
            Todo todo=todoRepo.findById(todoId).orElseThrow();
            todo.setTodoStatus(todoStatus);
            return "Todo Id: " +todoId +" is update";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public String deleteTodoById(String email,String tokenValue, Integer todoId) {
        if(pTokenService.authenticate(email, tokenValue)) {
            Todo todo=todoRepo.findById(todoId).orElseThrow();
            todoRepo.deleteById(todoId);

            return "Todo Id: " +todoId +" is delete";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public List<Todo> getAllTodoByTodoStatus(String email,String tokenValue,Boolean todoStatus) {
        if(pTokenService.authenticate(email, tokenValue)) {
            return todoRepo.findAllTodoByTodoStatus(todoStatus);
        }
        else {
            return null;
        }
    }
}
