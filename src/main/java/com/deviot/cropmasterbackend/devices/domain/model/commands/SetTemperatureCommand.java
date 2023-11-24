package com.deviot.cropmasterbackend.devices.domain.model.commands;

public record SetTemperatureCommand(Long deviceId,Double temperature,Double humidity) {
}
