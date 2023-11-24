package com.deviot.cropmasterbackend.ccm.domain.services.message;


import com.deviot.cropmasterbackend.ccm.domain.model.commands.chat.CreateMessageCommand;

public interface IMessageCommandService {
    String handle (CreateMessageCommand createMessageCommand);
}
