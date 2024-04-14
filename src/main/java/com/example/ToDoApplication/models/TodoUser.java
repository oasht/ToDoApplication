package com.example.ToDoApplication.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TodoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Todo> todos;

    public List<Todo>allByStatus(StatusType type){
        return todos.stream().filter((t)->type==t.status).toList();
    }
}
