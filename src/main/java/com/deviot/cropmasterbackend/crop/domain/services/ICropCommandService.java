package com.deviot.cropmasterbackend.crop.domain.services;

import com.deviot.cropmasterbackend.crop.domain.model.commands.*;
import com.deviot.cropmasterbackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.cropmasterbackend.crop.domain.model.commands.DeleteCropCommand;
import com.deviot.cropmasterbackend.crop.domain.model.commands.SetSpecialistToCropCommand;

public interface ICropCommandService {
    String handle(CreateCropCommand createCropCommand);

    String handle(SetSpecialistToCropCommand setSpecialistToCropCommand);
    String handle(DeleteCropCommand deleteCropCommand);



}
