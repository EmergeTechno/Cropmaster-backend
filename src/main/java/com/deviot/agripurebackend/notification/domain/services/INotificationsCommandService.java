package com.deviot.agripurebackend.notification.domain.services;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.commands.CreateNotificationCommand;
import com.deviot.agripurebackend.notification.domain.model.commands.DeleteNotificationCommand;


import java.util.List;

public interface INotificationsCommandService {
    String handle(CreateNotificationCommand createNotificationCommand);
    List<Notification> handle();
    String handle(DeleteNotificationCommand deleteNotificationCommand);

    void  deleteNotificationsByUserId(Long userId);
}
