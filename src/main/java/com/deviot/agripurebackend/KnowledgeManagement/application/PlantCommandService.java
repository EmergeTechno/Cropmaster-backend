package com.deviot.agripurebackend.KnowledgeManagement.application;

import com.deviot.agripurebackend.KnowledgeManagement.domain.model.aggregates.Plant;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.commands.CreatePlantCommand;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.commands.DeletePlantCommand;
import com.deviot.agripurebackend.KnowledgeManagement.domain.services.IPlantCommandService;
import com.deviot.agripurebackend.KnowledgeManagement.infrastructure.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantCommandService implements IPlantCommandService {
    private final PlantRepository plantRepository;
    @Override
    public Long handle(CreatePlantCommand createPlantCommand) {
        Plant plant=Plant.builder().name(createPlantCommand.name())
                .scientificName(createPlantCommand.scientificName())
                .imageUrl(createPlantCommand.imageUrl())
                .variety(createPlantCommand.variety())
                .landType(createPlantCommand.landType())
                .weatherConditions(createPlantCommand.weatherConditions())
                .distanceBetweenPlants(createPlantCommand.distanceBetWeenPlants())
                .idealPlantingDepth(createPlantCommand.idealPlantingDepth())
                .fertilizationAndFumigation(createPlantCommand.fertilizationAndFumigation())
                .build();
        plantRepository.save(plant);
        return 1L;
    }

    @Override
    public Long handle(DeletePlantCommand deletePlantCommand) {
        Optional<Plant> plant=plantRepository.findById(deletePlantCommand.id());
        if(plant.isPresent()){
            plantRepository.delete(plant.get());
            return 1L;
        }
        else{
            return 0L;
        }
    }
}
