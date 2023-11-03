package com.deviot.cropmasterbackend.advisory.interfaces.rest;

import com.deviot.cropmasterbackend.advisory.application.internal.project.ProjectCommandService;
import com.deviot.cropmasterbackend.advisory.application.internal.project.ProjectQueryService;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.project.CreateProjectCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.project.DeleteProjectCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.project.StartProjectCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.entities.Project;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.proyect.GetProjectByIdQuery;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.proyect.GetProjectsByFarmerIdQuery;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.proyect.GetProjectsBySpecialistIdQuery;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;


    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody CreateProjectCommand createProjectCommand){
        this.projectCommandService.handle(createProjectCommand);
        return ResponseEntity.ok("Project Created!!");
    }

    @GetMapping("/projectsById/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable("projectId") Long projectId){
        GetProjectByIdQuery getProjectByIdQuery=new GetProjectByIdQuery(projectId);
        Project project=this.projectQueryService.handle(getProjectByIdQuery);
        if(project!=null){
            return ResponseEntity.ok(project);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/projectsByFarmerId/{farmerId}")
    public ResponseEntity<?> getProjectsByFarmerId(@PathVariable("farmerId") Long farmerId){
        GetProjectsByFarmerIdQuery getProjectsByFarmerIdQuery=new GetProjectsByFarmerIdQuery(farmerId);
        List<Project> projects=this.projectQueryService.handle(getProjectsByFarmerIdQuery);
        if(projects!=null){
            return ResponseEntity.ok(projects);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/projectsBySpecialistId/{specialistId}")
    public ResponseEntity<?> getProjectsBySpecialistId(@PathVariable("specialistId") Long specialistId){
        GetProjectsBySpecialistIdQuery getProjectsBySpecialistIdQuery=new GetProjectsBySpecialistIdQuery(specialistId);
        List<Project> projects=this.projectQueryService.handle(getProjectsBySpecialistIdQuery);
        if(projects!=null){
            return ResponseEntity.ok(projects);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/startProject/{projectId}")
    public ResponseEntity<?> startProjectById(@PathVariable("projectId") Long projectId){
        StartProjectCommand startProjectCommand=new StartProjectCommand(projectId);
        String message=this.projectCommandService.handle(startProjectCommand);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping(("/deleteProjectById/{projectId}"))
    public ResponseEntity<?> deleteProjectById(@PathVariable("projectId") Long projectId){
        DeleteProjectCommand deleteProjectCommand=new DeleteProjectCommand(projectId);
        String message=this.projectCommandService.handle(deleteProjectCommand);
        return ResponseEntity.ok(message);
    }
}
