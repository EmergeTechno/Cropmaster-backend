package com.deviot.cropmasterbackend.profile.domain.service;

import com.deviot.cropmasterbackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.cropmasterbackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.cropmasterbackend.profile.domain.model.commands.UpdateProfileCommand;

public interface IProfileCommandService {
    String handle(CreateProfileCommand createProfileCommand);

    String handle(UpdateProfileCommand updateProfileCommand);

    String handle(DeleteProfileCommand deleteProfileCommand);
}
