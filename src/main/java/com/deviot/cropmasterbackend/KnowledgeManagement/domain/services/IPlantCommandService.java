package com.deviot.cropmasterbackend.KnowledgeManagement.domain.services;

import com.deviot.cropmasterbackend.KnowledgeManagement.domain.model.commands.CreatePlantCommand;
import com.deviot.cropmasterbackend.KnowledgeManagement.domain.model.commands.DeletePlantCommand;

public interface IPlantCommandService {
    Long handle(CreatePlantCommand createPlantCommand);
    Long handle(DeletePlantCommand deletePlantCommand);

}
