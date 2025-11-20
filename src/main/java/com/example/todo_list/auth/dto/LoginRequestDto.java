package com.example.todo_list.auth.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class LoginRequestDto {
    private String username;
    private String password;
}
