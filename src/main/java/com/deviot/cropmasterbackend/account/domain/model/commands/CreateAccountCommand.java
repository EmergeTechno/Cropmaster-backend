package com.deviot.cropmasterbackend.account.domain.model.commands;

public record CreateAccountCommand( String email,String password,String type) {
}
