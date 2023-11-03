package com.deviot.cropmasterbackend.notification.domain.services.queryService;

import com.deviot.cropmasterbackend.notification.domain.model.aggregates.Notification;
import com.deviot.cropmasterbackend.notification.domain.model.queries.GetNotificationsByToAccountId;

import java.util.List;

public interface INotificationQueryService {
    List<Notification> handle(GetNotificationsByToAccountId getNotificationsByToAccountId);
}
