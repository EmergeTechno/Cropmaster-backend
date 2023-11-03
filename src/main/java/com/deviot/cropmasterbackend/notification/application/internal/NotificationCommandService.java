package com.deviot.cropmasterbackend.notification.application.internal;

import com.deviot.cropmasterbackend.notification.domain.model.aggregates.Notification;
import com.deviot.cropmasterbackend.notification.domain.model.commands.CreateNotificationCommand;
import com.deviot.cropmasterbackend.notification.domain.model.commands.DeleteNotificationCommand;
import com.deviot.cropmasterbackend.notification.domain.services.INotificationsCommandService;
import com.deviot.cropmasterbackend.notification.infrastructure.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationCommandService implements INotificationsCommandService {
    private final NotificationRepository notificationRepository;
    @Override
    public String handle(CreateNotificationCommand createNotificationCommand) {
        Notification newNotification = Notification.builder()
                .message(createNotificationCommand.message())
                .imageUrl(createNotificationCommand.imageUrl())
                .notificationType(createNotificationCommand.notificationType())
                .date(createNotificationCommand.date())
                .toAccountId(createNotificationCommand.toAccountId())
                .plantId(createNotificationCommand.plantId())
                .fromAccountId(createNotificationCommand.fromAccountId())
                .seen(false)
                .build();
        if (notificationRepository.save(newNotification)!=null){
            return "Notification registered";
        }
        return "Can't registered your notification";

    }

    @Override
    public String handle(DeleteNotificationCommand deleteNotificationCommand) {

        Optional<Notification> notification = notificationRepository.findById(deleteNotificationCommand.id());
        if (!notification.isEmpty()){
            this.notificationRepository.deleteById(deleteNotificationCommand.id());
            return "Notification with id"+deleteNotificationCommand.id()+"was deleted";
        }
        return "Notification with id:"+ deleteNotificationCommand.id()+"doesnt exists";
    }

}
