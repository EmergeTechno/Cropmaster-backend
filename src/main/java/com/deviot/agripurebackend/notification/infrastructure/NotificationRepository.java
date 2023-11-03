package com.deviot.agripurebackend.notification.infrastructure;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findNotificationsByUserId(Long userId);

    List<Notification> findNotificationBySpecialistId(Long specialistId);
}
