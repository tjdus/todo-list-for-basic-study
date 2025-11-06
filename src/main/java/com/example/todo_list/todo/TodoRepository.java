package com.example.todo_list.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByTitleContaining(String keyword);
    List<Todo> findByCompleted(Boolean completed);
    List<Todo> findByCreatedById(Long createdBy);
}
