package com.deviot.cropmasterbackend.profile.domain.service;

import com.deviot.cropmasterbackend.profile.domain.model.commands.specialist.CreateSpecialistCommand;
import com.deviot.cropmasterbackend.profile.domain.model.commands.specialist.DeleteSpecialistCommand;
import com.deviot.cropmasterbackend.profile.domain.model.commands.specialist.UpdateSpecialistCommand;

public interface ISpecialistCommandService {
    String handle(CreateSpecialistCommand createSpecialistCommand);
    String handle(DeleteSpecialistCommand deleteSpecialistCommand);
    String handle(UpdateSpecialistCommand updateSpecialistCommand);
}
