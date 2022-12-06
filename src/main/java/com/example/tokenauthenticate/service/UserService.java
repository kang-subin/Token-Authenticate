package com.example.tokenauthenticate.service;

import com.example.tokenauthenticate.domain.UserLoginResponse;
import com.example.tokenauthenticate.repository.UserRepository;
import com.example.tokenauthenticate.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Value("hello")
    private String secretKey;

    private Long expireTimeMs = 10000 * 60 * 60L;

    public UserLoginResponse login(String userName, String password) {
        String token = JwtTokenUtil.createToken(userName,secretKey,expireTimeMs);
        UserLoginResponse userLoginResponse = new UserLoginResponse(token);

        return userLoginResponse;
    }
}
