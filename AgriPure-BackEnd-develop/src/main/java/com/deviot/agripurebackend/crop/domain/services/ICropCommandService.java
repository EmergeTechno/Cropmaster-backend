package com.deviot.agripurebackend.crop.domain.services;

import com.deviot.agripurebackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropReportCommand;

public interface ICropCommandService {
    String handle(CreateCropCommand createCropCommand);


    String handle(DeleteCropCommand deleteCropCommand);



}
