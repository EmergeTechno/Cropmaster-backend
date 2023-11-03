package com.deviot.cropmasterbackend.advisory.domain.Services.message;


import com.deviot.cropmasterbackend.advisory.domain.model.commands.chat.CreateMessageCommand;

public interface IMessageCommandService {
    String handle (CreateMessageCommand createMessageCommand);
}
