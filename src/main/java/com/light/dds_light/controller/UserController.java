package com.light.dds_light.controller;

import com.light.dds_light.config.TokenConfig;
import com.light.dds_light.dto.request.CreateUserRequest;
import com.light.dds_light.dto.request.LoginRequest;
import com.light.dds_light.dto.response.LoginResponse;
import com.light.dds_light.dto.response.UserResponse;
import com.light.dds_light.entities.User;
import com.light.dds_light.exceptions.UsernameOrPasswordInvalidException;
import com.light.dds_light.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dds/auth")
public class UserController {

    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public UserController(UserService service,  AuthenticationManager authenticationManager,  TokenConfig tokenConfig) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
            Authentication authentication = authenticationManager.authenticate(userAndPass);
            User user  = (User) authentication.getPrincipal();
            String token = tokenConfig.generateToken(user);
            return ResponseEntity.ok(new LoginResponse(token));
        }catch (BadCredentialsException e){
            throw new UsernameOrPasswordInvalidException("Email or password is incorrect");
        }
    }
}
