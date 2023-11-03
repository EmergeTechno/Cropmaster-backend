package com.deviot.agripurebackend.KnowledgeManagement.interfaces.rest;

import com.deviot.agripurebackend.KnowledgeManagement.application.PlantCommandService;
import com.deviot.agripurebackend.KnowledgeManagement.application.PlantQueryService;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.aggregates.Plant;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.commands.CreatePlantCommand;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.queries.GetPlantByIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/plant")
public class PlantController {
    private final PlantCommandService plantCommandService;
    private final PlantQueryService plantQueryService;

    @PostMapping
    public ResponseEntity<?> createPlant(@RequestBody CreatePlantCommand createPlantCommand){
        plantCommandService.handle(createPlantCommand);
        return ResponseEntity.ok("Plant created!!");
    }


    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants(){
        List<Plant> plants=plantQueryService.handle();
        return ResponseEntity.ok(plants);
    }

    @GetMapping("/{plantId}")
    public ResponseEntity<Plant> getPLantById(@PathVariable("plantId") Long plantId){
        GetPlantByIdQuery getPlantByIdQuery=new GetPlantByIdQuery(plantId);
        Plant plant=plantQueryService.handle(getPlantByIdQuery);
        return ResponseEntity.ok(plant);
    }
}
