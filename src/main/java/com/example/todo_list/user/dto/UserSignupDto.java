package com.example.todo_list.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserSignupDto {
    private String username;
    private String password;
    private String name;
}
