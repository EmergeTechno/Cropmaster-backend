package com.deviot.cropmasterbackend.notification.application.internal.QueryService;

import com.deviot.cropmasterbackend.notification.domain.model.aggregates.Notification;
import com.deviot.cropmasterbackend.notification.domain.model.queries.GetNotificationsByToAccountId;
import com.deviot.cropmasterbackend.notification.domain.services.queryService.INotificationQueryService;
import com.deviot.cropmasterbackend.notification.infrastructure.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationQueryService implements INotificationQueryService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<Notification> handle(GetNotificationsByToAccountId getNotificationsByToAccountId) {
        List<Notification> notifications = notificationRepository.findNotificationByToAccountId(getNotificationsByToAccountId.toAccountId());
        return notifications;
    }
}
