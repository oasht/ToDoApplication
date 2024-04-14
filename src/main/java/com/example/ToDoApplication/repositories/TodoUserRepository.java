package com.example.ToDoApplication.repositories;

import com.example.ToDoApplication.models.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoUserRepository extends JpaRepository<TodoUser, Long> {
    TodoUser findByName(String name);
}
