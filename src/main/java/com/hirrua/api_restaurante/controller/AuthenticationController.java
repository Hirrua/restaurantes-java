package com.hirrua.api_restaurante.controller;

import com.hirrua.api_restaurante.dtos.customer.CustomerLoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerLoginRequest customerLoginRequest) {
        var userPasswordToken = new UsernamePasswordAuthenticationToken(customerLoginRequest.email(), customerLoginRequest.password());
        var auth = authenticationManager.authenticate(userPasswordToken);

        System.out.println(userPasswordToken);
        System.out.println(auth);

        return ResponseEntity.ok().build();
    }
}
