package com.deviot.cropmasterbackend.ccm.infrastructure;

import com.deviot.cropmasterbackend.ccm.domain.model.aggregates.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findNotificationByToAccountId(Long toAccountId);

}
