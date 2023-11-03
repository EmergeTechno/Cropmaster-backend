package com.deviot.cropmasterbackend.advisory.domain.model.commands.contact;

public record CreateContactCommand(Long farmerId,Long specialistId,Boolean isChatStarted) {
}
