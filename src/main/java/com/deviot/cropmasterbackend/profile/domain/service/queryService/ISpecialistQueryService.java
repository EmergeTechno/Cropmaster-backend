package com.deviot.cropmasterbackend.profile.domain.service.queryService;

import com.deviot.cropmasterbackend.profile.domain.model.aggregates.Specialist;
import com.deviot.cropmasterbackend.profile.domain.model.queries.specialist.GetSpecialistByAccountIdQuery;

public interface ISpecialistQueryService {
    Specialist handle(GetSpecialistByAccountIdQuery getSpecialistByAccountIdQuery);

}
