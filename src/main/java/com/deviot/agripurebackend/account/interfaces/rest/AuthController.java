package com.deviot.agripurebackend.account.interfaces.rest;

import com.deviot.agripurebackend.account.application.internal.AccountCommandService;
import com.deviot.agripurebackend.account.domain.model.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.model.commands.LogInCommand;
import com.deviot.agripurebackend.account.infrastructure.dtos.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AccountCommandService accountCommandService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> logIn(@RequestBody LogInCommand logInCommand){
        return ResponseEntity.ok(this.accountCommandService.handle(logInCommand));
    }

    @PostMapping(value="register")
    public ResponseEntity<AuthResponse> register(@RequestBody CreateAccountCommand createAccountCommand){
        return ResponseEntity.ok(this.accountCommandService.handle(createAccountCommand));
    }
}
