package com.deviot.cropmasterbackend.crop.interfaces.rest;

import com.deviot.cropmasterbackend.crop.application.internal.CropCommandService;
import com.deviot.cropmasterbackend.crop.application.internal.QueryService.CropQueryService;
import com.deviot.cropmasterbackend.crop.domain.model.aggregates.Crop;
import com.deviot.cropmasterbackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.cropmasterbackend.crop.domain.model.commands.DeleteCropCommand;
import com.deviot.cropmasterbackend.crop.domain.model.queries.GetCropByIdQuery;
import com.deviot.cropmasterbackend.crop.domain.model.queries.GetCropsByFarmerIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/crops")
public class CropController {
    private final CropCommandService cropCommandService;
    private final CropQueryService cropQueryService;

    @PostMapping
    public ResponseEntity<?> createCrop(@RequestBody CreateCropCommand createCropCommand){
        this.cropCommandService.handle(createCropCommand);
        return ResponseEntity.ok("Crop created!!!");
    }

    @GetMapping("/{farmerId}")
    public ResponseEntity<?> getCropsByFarmerId(@PathVariable("farmerId") Long farmerId){

        GetCropsByFarmerIdQuery getCropsByFarmerIdQuery=new GetCropsByFarmerIdQuery(farmerId);
        List<Crop> crops=this.cropQueryService.handle(getCropsByFarmerIdQuery);
        return ResponseEntity.ok(crops);
    }

    @GetMapping("/getCrop/{cropId}")
    public ResponseEntity<?> getCropById(@PathVariable("cropId") Long cropId){
        GetCropByIdQuery getCropByIdQuery=new GetCropByIdQuery(cropId);
        Crop crop= this.cropQueryService.handle(getCropByIdQuery);
        if(crop!=null){
            return ResponseEntity.ok(crop);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deleteCrop/{cropId}")
    public ResponseEntity<?> deleteCropById(@PathVariable("cropId") Long cropId){
        DeleteCropCommand deleteCropCommand=new DeleteCropCommand(cropId);
        String message=this.cropCommandService.handle(deleteCropCommand);
        return ResponseEntity.ok(message);
    }
}
