package com.deviot.cropmasterbackend.advisory.domain.Services.contact;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.contact.CreateContactCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.contact.DeleteContactCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.contact.StartChatCommand;

public interface IContactCommandService {
    String handle(CreateContactCommand createContactCommand);

    String handle(DeleteContactCommand deleteContactCommand);
    String handle(StartChatCommand startChatCommand);
}
