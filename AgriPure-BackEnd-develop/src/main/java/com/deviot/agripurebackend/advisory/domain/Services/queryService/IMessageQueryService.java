package com.deviot.agripurebackend.advisory.domain.Services.queryService;

import com.deviot.agripurebackend.advisory.domain.model.entities.Message;
import com.deviot.agripurebackend.advisory.domain.model.queries.chat.GetMessageByContactIdQuery;

import java.util.List;


public interface IMessageQueryService {
    List<Message> handle (GetMessageByContactIdQuery getMessageByContactIdQuery);
}
