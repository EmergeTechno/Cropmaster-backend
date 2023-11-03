package com.deviot.cropmasterbackend.crop.application.internal.QueryService;


import com.deviot.cropmasterbackend.crop.domain.model.aggregates.CropReport;
import com.deviot.cropmasterbackend.crop.domain.model.queries.GetCropReportByIdQuery;
import com.deviot.cropmasterbackend.crop.domain.model.queries.GetCropReportsByCropIdQuery;
import com.deviot.cropmasterbackend.crop.domain.services.queryService.ICropReportQueryService;
import com.deviot.cropmasterbackend.crop.infrastructure.CropReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CropReportQueryService implements ICropReportQueryService {
    private final CropReportRepository cropReportRepository;

    @Override
    public CropReport handle(GetCropReportByIdQuery getCropReportByIdQuery) {
        Optional<CropReport> cropReport=cropReportRepository.findById(getCropReportByIdQuery.cropReportId());
        if(cropReport.isPresent()){
            return cropReport.get();
        }
        else{
            return null;
        }

    }

    @Override
    public List<CropReport> handle(GetCropReportsByCropIdQuery getCropReportsByCropIdQuery) {
        return cropReportRepository.findByCropId(getCropReportsByCropIdQuery.cropId());
    }
}
