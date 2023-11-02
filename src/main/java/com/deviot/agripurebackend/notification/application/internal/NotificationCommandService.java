package com.deviot.agripurebackend.notification.application.internal;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.commands.CreateNotificationCommand;
import com.deviot.agripurebackend.notification.domain.model.commands.DeleteNotificationCommand;
import com.deviot.agripurebackend.notification.domain.services.INotificationsCommandService;
import com.deviot.agripurebackend.notification.infrastructure.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationCommandService implements INotificationsCommandService {
    private final NotificationRepository notificationRepository;
    @Override
    public String handle(CreateNotificationCommand createNotificationCommand) {
        Notification newNotification = Notification.builder()
                .userId(createNotificationCommand.userId())
                .specialistId(createNotificationCommand.specialistId())
                .importance(createNotificationCommand.importance())
                .message(createNotificationCommand.message())
                .imageUrl("https://s2.abcstatics.com/media/bienestar/2020/09/01/lechuga-kSlD--1248x698@abc.jpg")
                .seen(false)
                .plantId(createNotificationCommand.plantId())
                .createAt(new Date())
                .build();
        if (notificationRepository.save(newNotification)!=null){
            return "Notification registered";
        }
        return "Can't registered your notification";

    }

    @Override
    public List<Notification> handle() {
        return notificationRepository.findAll();
    }

    @Override
    public String handle(DeleteNotificationCommand deleteNotificationCommand) {

        List<Notification> notifications = notificationRepository.findNotificationsByUserId(deleteNotificationCommand.id());
        if (!notifications.isEmpty()){
            for (Notification notification: notifications){
                notificationRepository.delete(notification);
            }
            return "Notification with id"+deleteNotificationCommand.id()+"was deleted";
        }
        return "Notification with id:"+ deleteNotificationCommand.id()+"doesnt exists";
    }

    @Override
    public void deleteNotificationsByUserId(Long userId) {
        List<Notification> notifications = notificationRepository.findNotificationsByUserId(userId);
        if (!notifications.isEmpty()){
            for (Notification notification: notifications){
                notificationRepository.delete(notification);
            }
        }
    }
}
