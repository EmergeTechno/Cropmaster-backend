package com.deviot.cropmasterbackend.crop.application.internal;

import com.deviot.cropmasterbackend.crop.domain.model.aggregates.CropReport;
import com.deviot.cropmasterbackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.cropmasterbackend.crop.domain.model.commands.DeleteCropReportCommand;
import com.deviot.cropmasterbackend.crop.domain.services.ICropReportCommandService;
import com.deviot.cropmasterbackend.crop.infrastructure.CropReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CropReportCommandService implements ICropReportCommandService {

    private final CropReportRepository cropReportRepository;
    @Override
    public String handle(AddCropReportCommand addCropReportCommand) {
        CropReport report=CropReport.builder()
                .createdAt(new Date())
                .description(addCropReportCommand.description())
                .image(addCropReportCommand.image())
                .cropId(addCropReportCommand.cropId())
                .build();
        cropReportRepository.save(report);
        return "Report registered!!!";

    }


    @Override
    public String handle(DeleteCropReportCommand deleteCropReportCommand) {
        Optional<CropReport> report=cropReportRepository.findById(deleteCropReportCommand.reportId());
        if(report.isPresent()){
            cropReportRepository.deleteById(deleteCropReportCommand.reportId());
            return "Report with ID: "+deleteCropReportCommand.reportId()+" was deleted";
        }
        return "Report with ID:"+deleteCropReportCommand.reportId()+" doesn't exist";
    }
}
