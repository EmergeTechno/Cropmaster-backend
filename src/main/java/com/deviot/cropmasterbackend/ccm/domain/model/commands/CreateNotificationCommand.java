package com.deviot.cropmasterbackend.ccm.domain.model.commands;

public record CreateNotificationCommand(String message,
                                        String imageUrl,
                                        String notificationType,
                                        String date,
                                        Long toAccountId,
                                        Long plantId,
                                        Long fromAccountId) {

}
