package com.deviot.cropmasterbackend.ccm.domain.services;

import com.deviot.cropmasterbackend.ccm.domain.model.commands.CreateNotificationCommand;
import com.deviot.cropmasterbackend.ccm.domain.model.commands.DeleteNotificationCommand;

public interface INotificationsCommandService {
    String handle(CreateNotificationCommand createNotificationCommand);
    String handle(DeleteNotificationCommand deleteNotificationCommand);

}
