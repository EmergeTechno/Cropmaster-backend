package com.deviot.cropmasterbackend.devices.domain.service.queryService;

import com.deviot.cropmasterbackend.devices.domain.model.aggregate.Device;
import com.deviot.cropmasterbackend.devices.domain.model.queries.*;

import com.deviot.cropmasterbackend.devices.interfaces.DTOs.TemperatureAndHumidity;
import com.deviot.cropmasterbackend.devices.domain.model.queries.*;

import java.util.List;

public interface IDeviceQueryService {

    List<Device> handle(GetDevicesByCropIdQuery getDevicesByCropIdQuery);

    Device handle(getTemperatureQuery query);
    Device handle(GetDeviceByIdQuery query);


    List<TemperatureAndHumidity> handle(GetTemperaturesAndHumidityByCropIdQuery query);

    List<Device> handle(GetDevicesByFarmerIdQuery getDevicesByFarmerIdQuery);

}
