package com.deviot.agripurebackend.profile.application.internal;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.agripurebackend.profile.domain.services.IProfileCommandService;
import com.deviot.agripurebackend.profile.infrastructure.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public interface ProfileCommandService extends IProfileCommandService {

    final ProfileRepository profileRepository;
    @Override
    public String handle(CreateProfileCommand createProfileCommand) {
        Profile newProfile=Profile.builder()
                .userId(createProfileCommand.userId())
                .suscriptionId(createProfileCommand.suscriptionId())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        if(profileRepository.save(newProfile)!=null){
            return "CROP REGISTERED!!!";
        }
        return "CAN'T REGISTER YOUR CROP";
    }
    @Override
    public String handle(DeleteProfileCommand deleteProfileCommand) {
        Optional<Profile> profile=ProfileRepository.findProfileByUserId(deleteProfileCommand.userId());
        if(profile.isPresent()){
            profileRepository.deleteById(deleteProfileCommand.userId());
            return "User with Id "+deleteProfileCommand.userId()+" was deleted";
        }
        return " User with Id: "+deleteProfileCommand.userId()+" doesn´t exist";

    }

}