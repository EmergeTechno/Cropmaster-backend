package com.deviot.cropmasterbackend.subscription.domain.model.commands;

public record CreateSubscriptionCommand(Long accountId, String validDate,Boolean active) {
}
