package com.deviot.cropmasterbackend.kms.domain.services;

import com.deviot.cropmasterbackend.kms.domain.model.aggregates.Plant;
import com.deviot.cropmasterbackend.kms.domain.model.queries.GetPlantByIdQuery;
import com.deviot.cropmasterbackend.kms.domain.model.queries.GetTemperatureAndHumidityRangesByPlantIdQuery;
import com.deviot.cropmasterbackend.kms.interfaces.resources.RangesDTO;

import java.util.List;

public interface IPlantQueryService {
    Plant handle(GetPlantByIdQuery getPlantByIdQuery);
    RangesDTO handle(GetTemperatureAndHumidityRangesByPlantIdQuery query);
    List<Plant>handle();
}
