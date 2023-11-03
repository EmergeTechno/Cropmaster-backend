package com.deviot.cropmasterbackend.advisory.application.internal.message;

import com.deviot.cropmasterbackend.advisory.domain.Services.message.IMessageCommandService;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.chat.CreateMessageCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.entities.Message;
import com.deviot.cropmasterbackend.advisory.infrastructure.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageCommandService implements IMessageCommandService {
    private final MessageRepository messageRepository;
    @Override
    public String handle(CreateMessageCommand createMessageCommand){
        Message newMessage=Message.builder()
                .contactId(createMessageCommand.contactId())
                .authorId(createMessageCommand.authorId())
                .message(createMessageCommand.message())
                .hour(createMessageCommand.hour())
                .build();
        if(messageRepository.save(newMessage)!=null){
            return "MESSAGE CREATED";
        }
        return "CAN'T REGISTER YOUR CROP";
    }
}
