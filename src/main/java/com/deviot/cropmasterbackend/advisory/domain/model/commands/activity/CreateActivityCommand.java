package com.deviot.cropmasterbackend.advisory.domain.model.commands.activity;

public record CreateActivityCommand(Long projectId, String title,String description, String date) {

}
