package com.deviot.agripurebackend.advisory.application.internal.QueryService;

import com.deviot.agripurebackend.advisory.domain.Services.queryService.IMessageQueryService;
import com.deviot.agripurebackend.advisory.domain.model.entities.Message;
import com.deviot.agripurebackend.advisory.domain.model.queries.chat.GetMessageByContactIdQuery;
import com.deviot.agripurebackend.advisory.infrastructure.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageQueryService implements IMessageQueryService {
    private final MessageRepository messageRepository;

    @Override
    public List<Message> handle(GetMessageByContactIdQuery getMessageByContactIdQuery){
        List<Message>messages=messageRepository.findMessageByContactId(getMessageByContactIdQuery.ContactId());
        return messages;
    }
}
