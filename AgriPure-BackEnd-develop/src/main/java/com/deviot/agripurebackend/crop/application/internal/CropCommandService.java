package com.deviot.agripurebackend.crop.application.internal;

import com.deviot.agripurebackend.crop.domain.model.aggregates.Crop;
import com.deviot.agripurebackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropReportCommand;
import com.deviot.agripurebackend.crop.domain.services.ICropCommandService;
import com.deviot.agripurebackend.crop.infrastructure.CropRepository;
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
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        if(cropRepository.save(newCrop)!=null){
            return "CROP REGISTERED!!!";
        }
        return "CAN'T REGISTER YOUR CROP";
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
