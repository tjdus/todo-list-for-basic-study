package com.example.todo_list.auth;


import com.example.todo_list.auth.dto.LoginRequestDto;
import com.example.todo_list.auth.dto.LoginResponseDto;
import com.example.todo_list.auth.dto.SignupRequestDto;
import com.example.todo_list.auth.dto.SignupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
        SignupResponseDto dto = authService.signup(signupRequestDto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto dto = authService.login(loginRequestDto);
        return ResponseEntity.ok(dto);
    }
}
