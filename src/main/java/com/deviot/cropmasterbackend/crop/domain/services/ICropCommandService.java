package com.deviot.cropmasterbackend.crop.domain.services;

import com.deviot.cropmasterbackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.cropmasterbackend.crop.domain.model.commands.DeleteCropCommand;

public interface ICropCommandService {
    String handle(CreateCropCommand createCropCommand);


    String handle(DeleteCropCommand deleteCropCommand);



}
