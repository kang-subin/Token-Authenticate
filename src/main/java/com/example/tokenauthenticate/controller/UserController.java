package com.example.tokenauthenticate.controller;

import com.example.tokenauthenticate.domain.UserLoginRequest;
import com.example.tokenauthenticate.domain.UserLoginResponse;
import com.example.tokenauthenticate.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody UserLoginRequest userLoginRequest){
    UserLoginResponse userLoginResponse = userService.login(userLoginRequest.getUserName(), userLoginRequest.getPassword());
    return ResponseEntity.ok().body(userLoginResponse.getToken());
    }

}
