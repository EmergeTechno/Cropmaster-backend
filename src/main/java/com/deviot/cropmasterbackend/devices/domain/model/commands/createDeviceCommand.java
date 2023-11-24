package com.deviot.cropmasterbackend.devices.domain.model.commands;

public record createDeviceCommand(String name,String model,String category,String cropName,Long cropId,Long farmerId,Long projectId) {

}
