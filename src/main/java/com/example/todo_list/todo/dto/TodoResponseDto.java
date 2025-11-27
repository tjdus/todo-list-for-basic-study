package com.example.todo_list.todo.dto;


import com.example.todo_list.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TodoResponseDto {
    Long id;
    String title;
    Boolean completed;
    UserDto createdBy;
}