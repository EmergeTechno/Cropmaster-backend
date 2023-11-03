package com.deviot.cropmasterbackend.KnowledgeManagement.domain.services;

import com.deviot.cropmasterbackend.KnowledgeManagement.domain.model.aggregates.Plant;
import com.deviot.cropmasterbackend.KnowledgeManagement.domain.model.queries.GetPlantByIdQuery;

import java.util.List;

public interface IPlantQueryService {
    Plant handle(GetPlantByIdQuery getPlantByIdQuery);

    List<Plant>handle();
}
