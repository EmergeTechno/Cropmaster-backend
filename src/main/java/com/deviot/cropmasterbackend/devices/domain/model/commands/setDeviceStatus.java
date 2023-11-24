package com.deviot.cropmasterbackend.devices.domain.model.commands;

public record setDeviceStatus(Long deviceId,boolean newStatus) {
}
