package com.deviot.cropmasterbackend.account.domain.services;

import com.deviot.cropmasterbackend.account.domain.model.commands.CreateAccountCommand;
import com.deviot.cropmasterbackend.account.domain.model.commands.DeleteAccountCommand;
import com.deviot.cropmasterbackend.account.domain.model.commands.LogInCommand;
import com.deviot.cropmasterbackend.account.infrastructure.dtos.AuthResponse;

public interface AccountCommandService {

    AuthResponse handle(CreateAccountCommand createAccountCommand);
    AuthResponse handle(LogInCommand logInCommand);

    String handle(DeleteAccountCommand deleteAccountCommand);
}
