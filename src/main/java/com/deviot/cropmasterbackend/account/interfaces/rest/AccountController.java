package com.deviot.cropmasterbackend.account.interfaces.rest;

import com.deviot.cropmasterbackend.account.application.internal.AccountCommandService;
import com.deviot.cropmasterbackend.account.application.internal.QueryService.AccountQueryService;
import com.deviot.cropmasterbackend.profile.application.internal.ProfileCommandService;
import com.deviot.cropmasterbackend.profile.application.internal.SpecialistCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AccountController {
    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;
    private final ProfileCommandService profileCommandService;
    private final SpecialistCommandService specialistCommandService;

    @CrossOrigin
    @PostMapping(value = "prueba")
    public String Welcome(){
        return "Welcome to agripure";
    }
}
