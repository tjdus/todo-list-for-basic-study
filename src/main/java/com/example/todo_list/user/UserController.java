package com.example.todo_list.user;


import com.example.todo_list.user.dto.UserDto;
import com.example.todo_list.user.dto.UserSignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello User!");
    }

    @PostMapping("")
    public ResponseEntity<UserDto> create(@RequestBody UserSignupDto userDto) {
        UserDto createdUser = userService.create(userDto);
        return ResponseEntity.ok(createdUser);
    }



}
