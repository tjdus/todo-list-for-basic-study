package com.example.todo_list.auth;

import com.example.todo_list.auth.dto.LoginRequestDto;
import com.example.todo_list.auth.dto.LoginResponseDto;
import com.example.todo_list.auth.dto.SignupRequestDto;
import com.example.todo_list.auth.dto.SignupResponseDto;
import com.example.todo_list.security.JwtTokenProvider;
import com.example.todo_list.user.User;
import com.example.todo_list.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = User.builder()
                .name(signupRequestDto.getName())
                .username(signupRequestDto.getUsername())
                .password(encodedPassword)
                .build();

        User savedUser = userRepository.save(user);


        return SignupResponseDto.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .build();
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        // User 찾기
        User user = userRepository.findByUsername(loginRequestDto.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        // 비밀번호 확인
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // 토큰 생성 및 반환
        String token = jwtTokenProvider.generateToken(user.getId());
        return LoginResponseDto.builder()
                .token(token)
                .build();
    }


}
