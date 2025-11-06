package com.example.todo_list.user;

import com.example.todo_list.user.dto.UserDto;
import com.example.todo_list.user.dto.UserSignupDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto create(UserSignupDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .build();
        User savedUser = userRepository.save(user);
        return UserDto.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .name(savedUser.getName())
                .build();
    }


}
