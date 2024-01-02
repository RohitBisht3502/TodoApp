package com.ResoTech.Todo.Api.controller;

import com.ResoTech.Todo.Api.model.Todo;
import com.ResoTech.Todo.Api.model.User;
import com.ResoTech.Todo.Api.model.dto.AuthenticationInputDto;
import com.ResoTech.Todo.Api.model.dto.SignInInputDto;
import com.ResoTech.Todo.Api.service.TodoService;
import com.ResoTech.Todo.Api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TodoService todoService;
    //sign up
    @PostMapping("user/signup")
    public String userSignUp(@Valid @RequestBody User user)
    {
        return userService.userSignUp(user);
    }



    //sign in
    @PostMapping("user/signIn")
    public String patientSignIn(@RequestBody SignInInputDto signInInput)
    {
        return userService.userSignIn(signInInput);
    }


    //sign out
    @DeleteMapping("user/signOut")
    public String patientSignOut(@RequestParam String email,@RequestParam String tokenValue)
    {
        return userService.userSignOut(email, tokenValue);
    }

    // post a todo
    @PostMapping("todo")
    public String postTodo(@RequestParam String email,@RequestParam String tokenValue, @RequestBody Todo todo)
    {
        return todoService.postTodo(email,tokenValue,todo);
    }

    // get a todo
    @GetMapping("all/todo/")
    public List<Todo> getAllTodos(@RequestParam String email,@RequestParam String tokenValue){
        return todoService.getAllTodos(email,tokenValue);
    }

    // get a todo by status
    @GetMapping("all/todo/{todoStatus}")
    public List<Todo> getAllTodoByTodoStatus(@RequestParam String email,@RequestParam String tokenValue,@PathVariable Boolean todoStatus){
        return todoService.getAllTodoByTodoStatus(email,tokenValue,todoStatus);
    }

    // update a todo

    @PutMapping("todo/{id}/{todoStatus}")
    public String updateTodo(@RequestParam String email,@RequestParam String tokenValue,@PathVariable Integer todoId,@PathVariable Boolean todoStatus){
        return todoService.updateTodo(email,tokenValue,todoId,todoStatus);
    }

    // delete todo with todoId
    @DeleteMapping("todo/{todoId}")
    public String deleteTodoById(@RequestParam String email,@RequestParam String tokenValue,@PathVariable Integer todoId){
        return todoService.deleteTodoById(email,tokenValue,todoId);
    }

}
