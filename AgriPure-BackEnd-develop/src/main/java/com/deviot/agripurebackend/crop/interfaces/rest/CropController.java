package com.deviot.agripurebackend.crop.interfaces.rest;

import com.deviot.agripurebackend.crop.application.internal.CropCommandService;
import com.deviot.agripurebackend.crop.application.internal.QueryService.CropQueryService;
import com.deviot.agripurebackend.crop.domain.model.aggregates.Crop;
import com.deviot.agripurebackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropCommand;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropByIdQuery;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropsByFarmerIdQuery;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
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

    @GetMapping("/{farmerId}/{cropId}")
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
    @DeleteMapping
    public ResponseEntity<?> deleteCropById(@RequestBody DeleteCropCommand deleteCropCommand){

        String message=this.cropCommandService.handle(deleteCropCommand);
        return ResponseEntity.ok(message);
    }
}
