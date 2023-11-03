package com.deviot.cropmasterbackend.crop.domain.model.commands;


public record AddCropReportCommand(Long cropId, String description, String image) {
}
