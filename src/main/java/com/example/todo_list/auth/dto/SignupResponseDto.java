package com.example.todo_list.auth.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class SignupResponseDto {
    private Long id;
    private String name;
}
