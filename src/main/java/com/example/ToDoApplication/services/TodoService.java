package com.example.ToDoApplication.services;

import com.example.ToDoApplication.models.StatusType;
import com.example.ToDoApplication.models.Todo;
import com.example.ToDoApplication.repositories.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class TodoService {

    final TodoRepository todoRepository;

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public List<Todo> getAllByStatus(StatusType status) {
        return todoRepository.findByStatus(status);
    }

    public Todo getById(Long id) {
        return todoRepository.findById(id).orElseThrow();
    }

    public Todo save(Todo newTodo) {

        return todoRepository.save(newTodo);
    }
    @Transactional
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
