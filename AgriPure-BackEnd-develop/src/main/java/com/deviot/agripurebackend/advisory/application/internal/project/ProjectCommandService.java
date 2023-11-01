package com.deviot.agripurebackend.advisory.application.internal.project;

import com.deviot.agripurebackend.advisory.domain.Services.project.IProyectCommandService;
import com.deviot.agripurebackend.advisory.domain.model.commands.proyect.CreateProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.proyect.DeleteProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.proyect.StartProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.entities.Project;
import com.deviot.agripurebackend.advisory.infrastructure.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectCommandService implements IProyectCommandService {
    private final ProjectRepository projectRepository;
    @Override
    public String handle(CreateProjectCommand createProjectCommand) {
        Project newProject=Project.builder().farmerId(createProjectCommand.farmerId())
                .specialistId(createProjectCommand.specialistId())
                .isProjectStarted(false)
                .cropId(createProjectCommand.cropId())
                .name(createProjectCommand.name())
                .description(createProjectCommand.description())
                .startDate(createProjectCommand.startDate())
                .endDate(createProjectCommand.endDate())
                .build();
        projectRepository.save(newProject);
        return "Project created!!";
    }

    @Override
    public String handle(DeleteProjectCommand deleteProjectCommand) {
        Optional<Project> project=projectRepository.findById(deleteProjectCommand.projectId());
        if(project.isPresent()){
            projectRepository.deleteById(deleteProjectCommand.projectId());
            return "Project deleted!!";
        }
        else{
            return "Project with the given id doesn´t exist";
        }
    }

    @Override
    public String handle(StartProjectCommand startProjectCommand) {
        Optional<Project> project=projectRepository.findById(startProjectCommand.projectId());
        if(project.isPresent()){
            project.get().setProjectStarted(true);
            projectRepository.save(project.get());
            return "Project initialized!!";
        }
        else{
            return "Projet with the given id doesn't exist";
        }
    }
}
