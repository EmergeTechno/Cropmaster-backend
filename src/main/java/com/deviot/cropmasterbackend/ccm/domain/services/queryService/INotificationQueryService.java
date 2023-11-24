package com.deviot.cropmasterbackend.ccm.domain.services.queryService;

import com.deviot.cropmasterbackend.ccm.domain.model.aggregates.Notification;
import com.deviot.cropmasterbackend.ccm.domain.model.queries.GetNotificationsByToAccountId;

import java.util.List;

public interface INotificationQueryService {
    List<Notification> handle(GetNotificationsByToAccountId getNotificationsByToAccountId);
}
