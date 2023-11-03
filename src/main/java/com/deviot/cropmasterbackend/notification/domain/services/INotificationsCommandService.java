package com.deviot.cropmasterbackend.notification.domain.services;

import com.deviot.cropmasterbackend.notification.domain.model.commands.CreateNotificationCommand;
import com.deviot.cropmasterbackend.notification.domain.model.commands.DeleteNotificationCommand;

public interface INotificationsCommandService {
    String handle(CreateNotificationCommand createNotificationCommand);
    String handle(DeleteNotificationCommand deleteNotificationCommand);

}
