package com.deviot.agripurebackend.account.application.internal;

import com.deviot.agripurebackend.account.domain.model.aggregates.Account;
import com.deviot.agripurebackend.account.domain.model.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.model.commands.LogInCommand;
import com.deviot.agripurebackend.account.domain.model.enums.AccountRol;
import com.deviot.agripurebackend.account.infrastructure.dtos.AuthResponse;
import com.deviot.agripurebackend.account.infrastructure.repositories.AccountRepository;
import com.deviot.agripurebackend.account.jwt.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandService implements com.deviot.agripurebackend.account.domain.services.AccountCommandService {

    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponse handle(CreateAccountCommand createAccountCommand) {
        Account account=Account.builder().email(createAccountCommand.email()).password(passwordEncoder.encode(createAccountCommand.password()) ).rol(AccountRol.FARMER).build();
        this.accountRepository.save(account);
        return AuthResponse.builder().token(jwtService.getToken(account)).build();
    }

    @Override
    public AuthResponse handle(LogInCommand logInCommand) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInCommand.email(),logInCommand.password()));
        UserDetails account=accountRepository.findByEmail(logInCommand.email()).orElseThrow();
        String token=jwtService.getToken(account);
        return AuthResponse.builder().token(token).build();

    }
}
