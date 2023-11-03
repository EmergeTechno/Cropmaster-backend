package com.deviot.cropmasterbackend.profile.domain.service.queryService;

import com.deviot.cropmasterbackend.profile.domain.model.aggregates.Profile;
import com.deviot.cropmasterbackend.profile.domain.model.queries.GetProfileByAccountIdQuery;

public interface IProfileQueryService {

    Profile handle(GetProfileByAccountIdQuery getProfileByAccountIdQuery);

}
