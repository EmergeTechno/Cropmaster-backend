package com.deviot.agripurebackend.KnowledgeManagement.domain.services;

import com.deviot.agripurebackend.KnowledgeManagement.domain.model.commands.CreatePlantCommand;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.commands.DeletePlantCommand;

public interface IPlantCommandService {
    Long handle(CreatePlantCommand createPlantCommand);
    Long handle(DeletePlantCommand deletePlantCommand);

}
