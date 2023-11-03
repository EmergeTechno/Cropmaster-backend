package com.deviot.cropmasterbackend.advisory.application.internal.message;

import com.deviot.cropmasterbackend.advisory.domain.Services.message.IMessageQueryService;
import com.deviot.cropmasterbackend.advisory.domain.model.entities.Message;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.chat.GetMessageByContactIdQuery;
import com.deviot.cropmasterbackend.advisory.infrastructure.MessageRepository;
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
