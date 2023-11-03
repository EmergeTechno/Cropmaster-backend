package com.deviot.agripurebackend.advisory.domain.Services.project;

import com.deviot.agripurebackend.advisory.domain.model.commands.proyect.CreateProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.proyect.DeleteProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.proyect.StartProjectCommand;

public interface IProyectCommandService {
    String handle(CreateProjectCommand createProjectCommand);
    String handle(DeleteProjectCommand deleteProjectCommand);

    String handle(StartProjectCommand startProjectCommand);
}
