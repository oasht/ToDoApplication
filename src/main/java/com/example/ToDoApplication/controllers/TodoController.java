package com.example.ToDoApplication.controllers;

import com.example.ToDoApplication.models.StatusType;
import com.example.ToDoApplication.models.Todo;
import com.example.ToDoApplication.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

    final TodoService todoService;

    @PutMapping("/todos/{id}")
    public Todo updateTodoItem(@PathVariable("id") long id) {
        Todo updatedTodo = todoService.getById(id);
        if (updatedTodo.getStatus() == StatusType.BACKLOG) {
            updatedTodo.setStatus(StatusType.DOING);
        } else if (updatedTodo.getStatus() == StatusType.DOING) {
            updatedTodo.setStatus(StatusType.DONE);
        }
        return todoService.save(updatedTodo);
    }
}
