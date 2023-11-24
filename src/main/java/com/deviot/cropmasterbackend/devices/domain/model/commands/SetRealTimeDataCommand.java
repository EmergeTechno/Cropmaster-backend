package com.deviot.cropmasterbackend.devices.domain.model.commands;

public record SetRealTimeDataCommand(Long deviceId,boolean newStatus) {
}
