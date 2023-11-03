package com.deviot.cropmasterbackend.crop.domain.services;

import com.deviot.cropmasterbackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.cropmasterbackend.crop.domain.model.commands.DeleteCropReportCommand;

import java.io.IOException;

public interface ICropReportCommandService {
    String handle(AddCropReportCommand addCropReportCommand) throws IOException;
    String handle(DeleteCropReportCommand deleteCropReportCommand);
}
