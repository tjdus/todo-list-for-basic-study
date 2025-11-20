package com.example.todo_list.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello User!");
    }


    @GetMapping("/authenticated")
    public ResponseEntity<String> authenticatedWithUserDetails(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok("Hello " + (userDetails != null ? userDetails.getUsername() : "anonymous"));
    }



}
