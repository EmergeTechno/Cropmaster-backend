package com.deviot.agripurebackend.advisory.domain.model.commands.proyect;

import java.util.Date;

public record CreateProjectCommand(Long farmerId, Long specialistId, boolean isStarted, Long cropId, String name,String description,
                                   Date startDate,Date endDate) {
}
