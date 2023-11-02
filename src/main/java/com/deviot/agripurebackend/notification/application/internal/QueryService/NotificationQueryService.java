package com.deviot.agripurebackend.notification.application.internal.QueryService;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsBySpecialistId;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsByUserId;
import com.deviot.agripurebackend.notification.domain.services.queryService.INotificationQueryService;
import com.deviot.agripurebackend.notification.infrastructure.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationQueryService implements INotificationQueryService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<Notification> handle(GetNotificationsBySpecialistId getNotificationsBySpecialistId) {
        List<Notification> notifications = notificationRepository.findNotificationBySpecialistId(getNotificationsBySpecialistId.specialistId());
        return notifications;
    }

    @Override
    public List<Notification> handle(GetNotificationsByUserId getNotificationsByUserId) {
        List<Notification> notification = notificationRepository.findNotificationsByUserId(getNotificationsByUserId.userId());
        return notification;
    }
}
