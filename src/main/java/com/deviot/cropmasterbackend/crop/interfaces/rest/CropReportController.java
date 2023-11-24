package com.deviot.cropmasterbackend.crop.interfaces.rest;

import com.deviot.cropmasterbackend.crop.application.internal.CropReportCommandService;
import com.deviot.cropmasterbackend.crop.application.internal.QueryService.CropReportQueryService;
import com.deviot.cropmasterbackend.crop.domain.model.aggregates.CropReport;
import com.deviot.cropmasterbackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.cropmasterbackend.crop.domain.model.queries.GetCropReportByIdQuery;
import com.deviot.cropmasterbackend.crop.domain.model.queries.GetCropReportsByCropIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

@RequestMapping("api/v1/CropReports")
public class CropReportController {
    private final CropReportCommandService cropReportCommandService;
    private final CropReportQueryService cropReportQueryService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createCropReport(@RequestBody AddCropReportCommand addCropReportCommand){
        this.cropReportCommandService.handle(addCropReportCommand);
        return ResponseEntity.ok("Crop report created!!");
    }
    @CrossOrigin
    @GetMapping("/getCropReport/{cropReportId}")
    public ResponseEntity<?> getCropReportById(@PathVariable("cropReportId") Long cropReportId){
        GetCropReportByIdQuery getCropReportByIdQuery=new GetCropReportByIdQuery(cropReportId);

        CropReport cropReport=this.cropReportQueryService.handle(getCropReportByIdQuery);
        if(cropReport!=null){
            return ResponseEntity.ok(cropReport);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @GetMapping("/{cropId}")
    public ResponseEntity<?> getCropsByFarmerId(@PathVariable("cropId") Long cropId){
        GetCropReportsByCropIdQuery getCropReportsByCropIdQuery=new GetCropReportsByCropIdQuery(cropId);

        List<CropReport>reports=this.cropReportQueryService.handle(getCropReportsByCropIdQuery);

        return ResponseEntity.ok(reports);
    }
}
