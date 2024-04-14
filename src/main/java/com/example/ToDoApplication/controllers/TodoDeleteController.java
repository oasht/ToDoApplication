package com.example.ToDoApplication.controllers;

import com.example.ToDoApplication.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoDeleteController {
    final TodoService todoService;

    @DeleteMapping("/todos/{id}")
    public void deleteTodoItem(@PathVariable("id") Long id) {
        todoService.deleteById(id);
    }
}
