package com.example.ToDoApplication.services;

import com.example.ToDoApplication.models.Todo;
import com.example.ToDoApplication.models.TodoUser;
import com.example.ToDoApplication.repositories.TodoRepository;
import com.example.ToDoApplication.repositories.TodoUserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TodoUserService {
    final TodoUserRepository userRepository;
    final TodoRepository todoRepository;
    @Transactional
    public TodoUser getOrCreate(String name) {

        TodoUser byName = userRepository.findByName(name);
        if (byName == null) byName = new TodoUser(null, name, new ArrayList<>());
        return userRepository.save(byName);

    }
    @Transactional
    public Todo createTask(TodoUser todoUser, Todo todo){
        todo=todoRepository.save(todo);
        todoUser.getTodos().add(todo);
        userRepository.save(todoUser);
        return todo;
    }
}
