package com.deviot.cropmasterbackend.devices.domain.model.commands;

public record setActiveNotification(Long deviceId,boolean newStatus) {
}
