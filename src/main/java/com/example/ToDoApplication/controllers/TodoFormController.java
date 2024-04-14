package com.example.ToDoApplication.controllers;

import com.example.ToDoApplication.models.StatusType;
import com.example.ToDoApplication.models.Todo;
import com.example.ToDoApplication.models.TodoUser;
import com.example.ToDoApplication.services.TodoService;
import com.example.ToDoApplication.services.TodoUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodoFormController {

    final TodoService todoService;
    final TodoUserService todoUserService;

    @PostMapping("/todos/new/{user}")
    public String createTodoItem(@Valid Todo newTodo, @PathVariable String user) {
        TodoUser todoUser= todoUserService.getOrCreate(user);
        newTodo.setStatus(StatusType.BACKLOG);
        todoUserService.createTask(todoUser,newTodo);
        return "redirect:/user/"+ user;
    }
}
