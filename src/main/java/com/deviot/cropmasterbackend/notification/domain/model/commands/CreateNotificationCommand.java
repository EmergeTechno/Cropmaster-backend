package com.deviot.cropmasterbackend.notification.domain.model.commands;

import java.util.Date;

public record CreateNotificationCommand(String message,
                                        String imageUrl,
                                        String notificationType,
                                        String date,
                                        Long toAccountId,
                                        Long plantId,
                                        Long fromAccountId) {

}
