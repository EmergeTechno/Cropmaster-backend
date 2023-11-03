package com.deviot.agripurebackend.notification.interfaces.rest;


import com.deviot.agripurebackend.notification.application.internal.NotificationCommandService;
import com.deviot.agripurebackend.notification.application.internal.QueryService.NotificationQueryService;
import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.commands.CreateNotificationCommand;
import com.deviot.agripurebackend.notification.domain.model.commands.DeleteNotificationCommand;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsBySpecialistId;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsByUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationCommandService notificationCommandService;

    private final NotificationQueryService notificationQueryService;

    @PostMapping
    public ResponseEntity<?> createNotification(@RequestBody CreateNotificationCommand createNotificationCommand){
        this.notificationCommandService.handle(createNotificationCommand);
        return ResponseEntity.ok("Notification created!!");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteNotification(@RequestBody DeleteNotificationCommand deleteNotificationCommand){
        this.notificationCommandService.handle(deleteNotificationCommand);
        return ResponseEntity.ok("Notification deleted");
    }

    @GetMapping("/specialist/{specialistId}")
    public ResponseEntity<?> getNotificationsBySpecialistId(@PathVariable("specialistId") Long specialistId){
        GetNotificationsBySpecialistId getNotificationsBySpecialistId = new GetNotificationsBySpecialistId(specialistId);
        List<Notification> notifications = this.notificationQueryService.handle(getNotificationsBySpecialistId);
        return ResponseEntity.ok(notifications);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getNotificationsByUserId(@PathVariable("userId") Long userId){
        GetNotificationsByUserId getNotificationsByUserId = new GetNotificationsByUserId(userId);
        List<Notification> notifications = this.notificationQueryService.handle(getNotificationsByUserId);
        return ResponseEntity.ok(notifications);

    }

}
