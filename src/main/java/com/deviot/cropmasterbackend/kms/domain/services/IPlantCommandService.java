package com.deviot.cropmasterbackend.kms.domain.services;

import com.deviot.cropmasterbackend.kms.domain.model.commands.CreatePlantCommand;
import com.deviot.cropmasterbackend.kms.domain.model.commands.DeletePlantCommand;
import com.deviot.cropmasterbackend.kms.domain.model.commands.GenerateSeedCommand;

public interface IPlantCommandService {
    String handle(GenerateSeedCommand generateSeedCommand);
    Long handle(CreatePlantCommand createPlantCommand);
    Long handle(DeletePlantCommand deletePlantCommand);

}
