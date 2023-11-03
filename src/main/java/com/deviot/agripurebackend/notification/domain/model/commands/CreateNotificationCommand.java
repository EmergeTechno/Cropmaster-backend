package com.deviot.agripurebackend.notification.domain.model.commands;

import com.deviot.agripurebackend.notification.domain.model.enums.NotificationImportance;

public record CreateNotificationCommand(Long userId, Long specialistId, Long plantId, String message, NotificationImportance importance) {

}
