package com.deviot.cropmasterbackend.subscription.domain.model.commands;

public record UpdateSubscriptionCommand(Long accountId, Boolean active) {
}
