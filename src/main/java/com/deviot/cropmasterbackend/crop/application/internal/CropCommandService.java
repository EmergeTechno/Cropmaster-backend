package com.deviot.cropmasterbackend.crop.application.internal;

import com.deviot.cropmasterbackend.crop.domain.model.entities.Crop;
import com.deviot.cropmasterbackend.crop.domain.model.commands.*;
import com.deviot.cropmasterbackend.crop.domain.services.ICropCommandService;
import com.deviot.cropmasterbackend.crop.infrastructure.CropRepository;
import com.deviot.cropmasterbackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.cropmasterbackend.crop.domain.model.commands.DeleteCropCommand;
import com.deviot.cropmasterbackend.crop.domain.model.commands.SetSpecialistToCropCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CropCommandService implements ICropCommandService {
    private final CropRepository cropRepository;
    @Override
    public String handle(CreateCropCommand createCropCommand) {
        Crop newCrop=Crop.builder()
                .farmerId(createCropCommand.farmerId())
                .plantId(createCropCommand.plantId())
                .specialistId((long)0)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        if(cropRepository.save(newCrop)!=null){
            return "CROP REGISTERED!!!";
        }
        return "CAN'T REGISTER YOUR CROP";
    }

    @Override
    public String handle(SetSpecialistToCropCommand setSpecialistToCropCommand) {
        Optional<Crop> crop=cropRepository.findById(setSpecialistToCropCommand.id());
        if (crop.isPresent()){
            crop.get().setSpecialistId(setSpecialistToCropCommand.specialistId());
            cropRepository.save(crop.get());
            return "crop updated!!";
        }
        else{
            return "crop with the given id doesn't exist";
        }
    }


    @Override
    public String handle(DeleteCropCommand deleteCropCommand) {


        Optional<Crop> crop=cropRepository.findById(deleteCropCommand.cropId());
        if(crop.isPresent()){
            cropRepository.deleteById(deleteCropCommand.cropId());
            return "Crop with Id "+deleteCropCommand.cropId()+" was deleted";
        }
        return "Crop with Id: "+deleteCropCommand.cropId()+" doesn´t exist";

    }


}
