package com.deviot.cropmasterbackend.profile.domain.service;

import com.deviot.cropmasterbackend.profile.domain.model.commands.specialist.CreateSpecialistCommand;
import com.deviot.cropmasterbackend.profile.domain.model.commands.specialist.DeleteSpecialistCommand;

public interface ISpecialistCommandService {
    String handle(CreateSpecialistCommand createSpecialistCommand);
    String handle(DeleteSpecialistCommand deleteSpecialistCommand);
}
