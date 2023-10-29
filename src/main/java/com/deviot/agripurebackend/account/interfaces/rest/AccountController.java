package com.deviot.agripurebackend.account.interfaces.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AccountController {

    @PostMapping(value = "prueba")
    public String Welcome(){
        return "Welcome to agripure";
    }
}
