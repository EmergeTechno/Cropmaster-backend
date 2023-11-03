package com.deviot.cropmasterbackend.advisory.domain.Services.message;

import com.deviot.cropmasterbackend.advisory.domain.model.entities.Message;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.chat.GetMessageByContactIdQuery;

import java.util.List;


public interface IMessageQueryService {
    List<Message> handle (GetMessageByContactIdQuery getMessageByContactIdQuery);
}
