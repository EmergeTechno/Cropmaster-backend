package com.deviot.cropmasterbackend.KnowledgeManagement.application;

import com.deviot.cropmasterbackend.KnowledgeManagement.domain.model.aggregates.Plant;
import com.deviot.cropmasterbackend.KnowledgeManagement.domain.model.queries.GetPlantByIdQuery;
import com.deviot.cropmasterbackend.KnowledgeManagement.domain.services.IPlantQueryService;
import com.deviot.cropmasterbackend.KnowledgeManagement.infrastructure.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantQueryService implements IPlantQueryService {
    private final PlantRepository plantRepository;
    @Override
    public Plant handle(GetPlantByIdQuery getPlantByIdQuery) {
        Optional<Plant> plant=plantRepository.findById(getPlantByIdQuery.plantId());
        if(plant.isPresent()){
            return plant.get();
        }
        else{
            throw new RuntimeException("The plant with the given id doesn't exist");
        }
    }

    @Override
    public List<Plant> handle() {
        List<Plant> plants= plantRepository.findAll();
        return plants;
    }
}