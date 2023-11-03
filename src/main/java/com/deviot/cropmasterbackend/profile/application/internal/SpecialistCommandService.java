package com.deviot.cropmasterbackend.profile.application.internal;

import com.deviot.cropmasterbackend.profile.domain.model.aggregates.Specialist;
import com.deviot.cropmasterbackend.profile.domain.model.commands.specialist.CreateSpecialistCommand;
import com.deviot.cropmasterbackend.profile.domain.model.commands.specialist.DeleteSpecialistCommand;
import com.deviot.cropmasterbackend.profile.domain.service.ISpecialistCommandService;
import com.deviot.cropmasterbackend.profile.infrastructure.SpecialistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialistCommandService implements ISpecialistCommandService {
    private final SpecialistRepository specialistRepository;
    @Override
    public String handle(CreateSpecialistCommand createSpecialistCommand) {
        Specialist newSpecialist=Specialist.builder()
                .accountId(createSpecialistCommand.accountId())
                .expertise(createSpecialistCommand.expertise())
                .areasOfFocus(createSpecialistCommand.areasOfFocus())
                .contactEmail(createSpecialistCommand.contactEmail())
                .build();
        if(specialistRepository.save(newSpecialist)!=null){
            return "SPECIALIST CREATED!!";
        }else {
            return "CANT REGISTER YOUR SPECIALIST";
        }
    }

    @Override
    public String handle(DeleteSpecialistCommand deleteSpecialistCommand) {

        Optional<Specialist> specialist= Optional.ofNullable(specialistRepository.findSpecialistByAccountId(deleteSpecialistCommand.accountId()));
        if(specialist.isPresent()){
            specialistRepository.deleteById(specialist.get().getId());
            return "SPECIALIST with Id "+deleteSpecialistCommand.accountId()+" was deleted";
        }else {
            return "SPECIALIST with Id: "+deleteSpecialistCommand.accountId()+" doesn´t exist";
        }
    }
}
