package com.example.todo_list.todo.dto;

import com.example.todo_list.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
