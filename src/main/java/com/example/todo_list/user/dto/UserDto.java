package com.example.todo_list.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String name;
}
