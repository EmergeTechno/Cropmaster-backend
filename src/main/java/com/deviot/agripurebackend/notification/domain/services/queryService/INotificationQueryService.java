package com.deviot.agripurebackend.notification.domain.services.queryService;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsBySpecialistId;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsByUserId;

import java.util.List;

public interface INotificationQueryService {
    List<Notification> handle(GetNotificationsBySpecialistId getNotificationsBySpecialistId);
    List<Notification> handle(GetNotificationsByUserId getNotificationsByUserId);
}
