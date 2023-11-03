package com.deviot.cropmasterbackend.notification.infrastructure;

import com.deviot.cropmasterbackend.notification.domain.model.aggregates.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findNotificationByToAccountId(Long toAccountId);

}
