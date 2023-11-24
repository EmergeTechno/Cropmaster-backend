package com.deviot.cropmasterbackend.profile.domain.model.commands.specialist;

public record UpdateSpecialistCommand(Long accountId, String expertise, String contactEmail, String areasOfFocus) {
}
