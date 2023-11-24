package com.deviot.cropmasterbackend.ccm.domain.services.message;

import com.deviot.cropmasterbackend.ccm.domain.model.entities.Message;
import com.deviot.cropmasterbackend.ccm.domain.model.queries.chat.GetMessageByContactIdQuery;

import java.util.List;


public interface IMessageQueryService {
    List<Message> handle (GetMessageByContactIdQuery getMessageByContactIdQuery);
}
