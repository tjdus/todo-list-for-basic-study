package com.example.todo_list.todo.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TodoDto {
    Long id;
    String title;
    Boolean completed;
}