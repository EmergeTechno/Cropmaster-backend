package com.deviot.cropmasterbackend.advisory.domain.model.commands.activity;

import java.util.Date;

public record CreateActivityCommand(Long projectId, String title,String description, String date) {

}
