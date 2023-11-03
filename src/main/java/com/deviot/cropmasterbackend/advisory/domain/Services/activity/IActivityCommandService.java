package com.deviot.cropmasterbackend.advisory.domain.Services.activity;

import com.deviot.cropmasterbackend.advisory.domain.model.commands.activity.CompleteActivityCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.activity.CreateActivityCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.activity.DeleteActivityCommand;

public interface IActivityCommandService {
    String handle(CreateActivityCommand createActivityCommand);
    String handle(DeleteActivityCommand deleteActivityCommand);

    String handle(CompleteActivityCommand completeActivityCommand);
}
