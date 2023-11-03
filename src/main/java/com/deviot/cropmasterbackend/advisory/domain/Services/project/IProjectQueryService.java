package com.deviot.cropmasterbackend.advisory.domain.Services.project;

import com.deviot.cropmasterbackend.advisory.domain.model.entities.Project;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.proyect.GetProjectByIdQuery;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.proyect.GetProjectsByFarmerIdQuery;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.proyect.GetProjectsBySpecialistIdQuery;

import java.util.List;

public interface IProjectQueryService {
    Project handle(GetProjectByIdQuery getProjectByIdQuery);
    List<Project> handle(GetProjectsByFarmerIdQuery getProjectsByFarmerIdQuery);

    List<Project> handle(GetProjectsBySpecialistIdQuery getProjectsBySpecialistIdQuery);
}
