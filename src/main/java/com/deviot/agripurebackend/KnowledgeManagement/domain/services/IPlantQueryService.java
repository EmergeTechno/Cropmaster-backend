package com.deviot.agripurebackend.KnowledgeManagement.domain.services;

import com.deviot.agripurebackend.KnowledgeManagement.domain.model.aggregates.Plant;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.queries.GetPlantByIdQuery;

import java.util.List;

public interface IPlantQueryService {
    Plant handle(GetPlantByIdQuery getPlantByIdQuery);

    List<Plant>handle();
}
