package com.deviot.agripurebackend.advisory.interfaces.rest;

import com.deviot.agripurebackend.advisory.application.internal.MessageCommandService;
import com.deviot.agripurebackend.advisory.application.internal.QueryService.MessageQueryService;
import com.deviot.agripurebackend.advisory.domain.model.commands.chat.CreateMessageCommand;
import com.deviot.agripurebackend.advisory.domain.model.entities.Message;
import com.deviot.agripurebackend.advisory.domain.model.queries.chat.GetMessageByContactIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageCommandService messageCommandService;
    private final MessageQueryService messageQueryService;

    @PostMapping
    public ResponseEntity<?> createMessage(@RequestBody CreateMessageCommand createMessageCommand){
        this.messageCommandService.handle(createMessageCommand);
        return ResponseEntity.ok("Message Created!");
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<?>getMessagesByContactId(@PathVariable("contactId") Long contactId){
        GetMessageByContactIdQuery getMessageByContactIdQuery=new GetMessageByContactIdQuery(contactId);
        List<Message> messages=this.messageQueryService.handle(getMessageByContactIdQuery);
        return ResponseEntity.ok(messages);
    }
}
